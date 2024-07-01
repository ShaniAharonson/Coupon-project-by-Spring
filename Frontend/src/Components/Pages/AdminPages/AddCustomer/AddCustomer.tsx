import { useNavigate } from "react-router-dom";
import "./AddCustomer.css";
import { Customer } from "../../../Models/Customer";
import { SubmitHandler, useForm } from "react-hook-form";
import axios from "axios";
import { Button, ButtonGroup, TextField, Typography } from "@mui/material";
import axiosJWT from "../../../../util/axiosJWT";
import { myStore } from "../../../../redux/Store";
import { addCustomerAction } from "../../../../redux/AdminReducer";
import notify from "../../../../util/notify";
import { useEffect, useState } from "react";

export function AddCustomer(): JSX.Element {
    const navigate = useNavigate();
    const [admin, setAdmin] = useState(false);
    const { register, handleSubmit, formState: { errors }, reset } = useForm<Customer>();

    useEffect(() => {
        setAdmin(myStore.getState().auth.userType === "ADMIN");
    }, []);

    const onSubmit: SubmitHandler<Customer> = (data) => {
  //      data.id = 0; // Ensure ID is initialized
        console.log("Data submitted: ", data);

        if (admin) {
            const token = myStore.getState().auth.token;
            axiosJWT.post("http://localhost:8080/addCustomer", data, {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
            .then(res => {
               // const newCustomerId = +res.data; // Parse the new customer ID
                data.id = +res.data;
                myStore.dispatch(addCustomerAction(data)); // Dispatch action to update Redux state
                notify.success("Customer is added!!");
                navigate("/customerAdded");
                reset(); // Reset form after successful submission
            })
            .catch(err => {
                console.error("Error response: ", err.response);
                const errorMessage = err.response?.data?.message || err.message || "Unknown error occurred";
                notify.error("Failed to add customer: " + errorMessage);
            });
        } else {
            axios.post("http://localhost:8080/register", data)
            .then(res => {
                notify.success("Register is completed");
                navigate("/Login");
                reset(); // Reset form after successful submission
            })
            .catch(err => {
                console.error("Error response: ", err.response);
                const errorMessage = err.response?.data?.message || err.message || "Unknown error occurred";
                notify.error("Failed to register: " + errorMessage);
            });
        }
    };

    return (
        <div className="AddCustomer">
            <div className="Box" style={{ width: "30%" }}>
                <form onSubmit={handleSubmit(onSubmit)}>
                    <Typography variant="h4" className="HeadLine">Add User</Typography>
                    <hr />
                    <TextField label="First Name" variant="outlined" {...register("firstName", { required: true, minLength: 2 })} />
                    {errors.firstName?.type === "required" && <><br /><span style={{ color: "red" }}>This field is required!!</span></>}
                    {errors.firstName?.type === "minLength" && <><br /><span style={{ color: "red" }}>Minimum 3 letters</span></>}
                    <br /><br />
                    <TextField label="Last Name" variant="outlined" {...register("lastName", { required: true, minLength: 2 })} />
                    {errors.lastName?.type === "required" && <><br /><span style={{ color: "red" }}>This field is required!!</span></>}
                    {errors.lastName?.type === "minLength" && <><br /><span style={{ color: "red" }}>Minimum 3 letters</span></>}
                    <br /><br />
                    <TextField label="Email" variant="outlined" {...register("email", { required: true })} />
                    {errors.email?.type === "required" && <><br /><span style={{ color: "red" }}>This field is required!!</span></>}
                    <br /><br />
                    <TextField label="Enter password" type="password" variant="outlined" {...register("password", { required: true, minLength: 3 })} />
                    {errors.password?.type === "required" && <><br /><span style={{ color: "red" }}>This field is required!!</span></>}
                    {errors.password?.type === "minLength" && <><br /><span style={{ color: "red" }}>Minimum 3 letters</span></>}
                    <br /><br />
                    <ButtonGroup variant="contained" fullWidth>
                        <Button type="submit" color="success">Add Customer</Button>
                        <Button value="Cancel" color="error" onClick={() => { navigate("/allCustomers") }}>Cancel</Button>
                    </ButtonGroup>
                </form>
            </div>
        </div>
    );
}
