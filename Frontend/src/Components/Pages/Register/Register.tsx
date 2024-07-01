import { Button, ButtonGroup, TextField, Typography } from "@mui/material";
import axios from "axios";
import { useForm, SubmitHandler } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import axiosJWT from "../../../util/axiosJWT";
import { myStore } from "../../../redux/Store";
import { addCustomerAction } from "../../../redux/AdminReducer";
import notify from "../../../util/notify";
import { Customer } from "../../Models/Customer";

export function Register(): JSX.Element {
    const navigate = useNavigate();
    const { register, handleSubmit, formState: { errors } } = useForm<Customer>();

    const onSubmit: SubmitHandler<Customer> = (data) => {
        data.id = 0; // Ensure ID is initialized properly for new customer registration
        console.log(data);
        
      //  const token = myStore.getState().auth.token;

        axiosJWT.post("http://localhost:8080/addCustomer", data, 
        //{
        //     headers: {
        //         'Authorization': `Bearer ${token}` // Include authorization header with the token
        //     }
        // }
    )
        .then(res => {
            data.id = +res.data; // Assuming the response contains the new customer ID
            myStore.dispatch(addCustomerAction(data)); // Dispatch Redux action to store the new customer data
            notify.success("Registration successful!");
            navigate("/customerAdded"); // Redirect to success page or relevant route
        })
        .catch(err => {
            console.error("Failed to register customer:", err);
            notify.error("Failed to register customer. Please try again.");
        });
    };

    return (
        <div className="Register">
            <div className="Box" style={{ width: "70%" }}>
                <Typography variant="h4" className="HeadLine">User Registration</Typography>
                <hr /><br />
                <form onSubmit={handleSubmit(onSubmit)}>
                    <TextField label="First Name" variant="outlined" {...register("firstName", { required: true, minLength: 2 })} fullWidth />
                    {errors.firstName?.type === "required" && <><br /><span style={{ color: "red" }}>This field is required!</span></>}
                    {errors.firstName?.type === "minLength" && <><br /><span style={{ color: "red" }}>Minimum 2 characters required</span></>}
                    <br /><br />
                    <TextField label="Last Name" variant="outlined" {...register("lastName", { required: true, minLength: 2 })} fullWidth />
                    {errors.lastName?.type === "required" && <><br /><span style={{ color: "red" }}>This field is required!</span></>}
                    {errors.lastName?.type === "minLength" && <><br /><span style={{ color: "red" }}>Minimum 2 characters required</span></>}
                    <br /><br />
                    <TextField label="Email" variant="outlined" {...register("email", { required: true })} fullWidth />
                    {errors.email?.type === "required" && <><br /><span style={{ color: "red" }}>This field is required!</span></>}
                    <br /><br />
                    <TextField label="Password" type="password" variant="outlined" {...register("password", { required: true, minLength: 6 })} fullWidth />
                    {errors.password?.type === "required" && <><br /><span style={{ color: "red" }}>This field is required!</span></>}
                    {errors.password?.type === "minLength" && <><br /><span style={{ color: "red" }}>Minimum 6 characters required</span></>}
                    <br /><br />
                    <ButtonGroup variant="contained" fullWidth>
                        <Button type="submit" color="primary">Register</Button>
                        <Button color="error" onClick={() => navigate("/")}>Cancel</Button>
                    </ButtonGroup>
                </form>
            </div>
        </div>
    );
}
