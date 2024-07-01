import { useEffect, useState } from "react";
import "./CustomerDetails.css";
import { Customer } from "../../../Models/Customer";
import { useNavigate } from "react-router-dom";
import { checkData } from "../../../../util/chekData";
import { myStore } from "../../../../redux/Store";
import axiosJWT from "../../../../util/axiosJWT";
import { getCustomerDetailsAction } from "../../../../redux/CustomerReducer";
import notify from "../../../../util/notify";
import { Typography } from "@mui/material";

export function CustomerDetails(): JSX.Element {
    const [customer, setCustomer] = useState<Customer | null>(null);
    const navigate = useNavigate();

    useEffect(() => {
        checkData();
        if(myStore.getState().auth.userType !== "CUSTOMER"){
            navigate("/Page404");
            notify.error("No Acess!!!!!");

        }
        const customerDetails = myStore.getState().customer.customer;
        const authId = myStore.getState().auth.id;

        console.log("Customer details from store:", customerDetails);
        console.log("Auth ID from store:", authId);

        if (!customerDetails || customerDetails.id === -1) {
            axiosJWT.get(`http://localhost:8080/customerDetails/${authId}`)
                .then(res => {
                    console.log("Fetched customer details:", res.data);
                    setCustomer(res.data);
                    myStore.dispatch(getCustomerDetailsAction(res.data));
                })
                .catch(err => {
                    console.error("Failed to fetch customer details:", err);
                    if (err.response) {
                        console.error("Error response data:", err.response.data);
                        console.error("Error response status:", err.response.status);
                        console.error("Error response headers:", err.response.headers);
                    }
                    notify.error("Failed to fetch customer details. Please check your request parameters and try again.");
                });
        } else {
            setCustomer(customerDetails);
        }
    }, []);

    if (!customer) {
        return <Typography>Loading...</Typography>;
    }


    return (
    <div className="customerDetails">
    <Typography variant="h2" style={{color:"InfoText"}}>Company Details</Typography>
    <Typography variant="h4" className="HeadLine">{customer.firstName}</Typography>
    <Typography variant="h6" className="HeadLine">{customer.lastName}</Typography>
    <br />
    <Typography variant="h6" className="HeadLine">{customer.email}</Typography>
    Your id: <Typography variant="h6" className="HeadLine">{customer.id}</Typography>
</div>
);
}