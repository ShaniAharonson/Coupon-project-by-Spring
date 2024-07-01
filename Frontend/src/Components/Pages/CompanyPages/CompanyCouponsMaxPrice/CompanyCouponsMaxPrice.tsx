import { useNavigate } from "react-router-dom";
import "./CompanyCouponsMaxPrice.css";
import { useEffect, useState } from "react";
import { Coupon } from "../../../Models/Coupon";
import axiosJWT from "../../../../util/axiosJWT";
import { myStore } from "../../../../redux/Store";
import { getCompanyCouponsMaxPriceAction } from "../../../../redux/CompanyReducer";
import { Button, ButtonGroup, TextField, Typography } from "@mui/material";
import { SingleCoupon } from "../../GuestPages/SingleCoupon/SingleCoupon";
import notify from "../../../../util/notify";

export function CompanyCouponsMaxPrice(): JSX.Element {
    const navigate = useNavigate();

    const [price, setPrice] = useState(0);
    const [coupons, setCoupons] = useState<Coupon[]>([]);

    // const handleCategoryChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    //     setPrice(+event.target.value);
    // }
    useEffect(()=>{
        if(myStore.getState().auth.userType !== "COMPANY"){
            navigate("/Page404");
            notify.error("No Acess!!!!!");

        }
    },[]);
    const getData = () => {
        axiosJWT.get<Coupon[]>(`http://localhost:8080/companyCouponsMaxPrice/${myStore.getState().auth.id}/${price}`)
            .then(response => {

                //myStore.dispatch(getCompanyCouponsMaxPriceAction(response.data))
                setCoupons(response.data);
            })
            .catch(error => {
                console.error("Failed to fetch company coupons by price:", error);
                navigate("/Login"); // Redirect to login page on error
            });
    };



    return (
        <div className="CompanyCouponsMaxPrice" style={{ width: "100%", height: "80vh", overflowY: "scroll" }}>
            <div className="Box">
                <TextField label="Enter Max Price" variant="outlined" onChange={(e) => setPrice(+e.target.value)} /> <br />
                <hr />
                <ButtonGroup variant="contained" fullWidth>
                    <Button type="submit" onClick={getData} color="success">Search</Button>
                    <Button color="error" onClick={() => navigate("/companyDetails")}>Cancel</Button>
                </ButtonGroup>
            </div>
            <hr />
            <div className="CouponsList">
                {coupons.length > 0 ? (
                    coupons.map((coupon) => (
                        <SingleCoupon key={coupon.id} coupon={coupon} />
                    ))
                ) : (
                    <Typography variant="body1">No coupons found for this price</Typography>
                )}
            </div>
        </div>
    );
}

/*
{coupons.length > 0 ? (
                coupons.map((coupon) => (
                    <SingleCoupon key={coupon.id} coupon={coupon} />
                ))
            ) : (
                <Typography variant="body1">No coupons found for this price</Typography>
            )}
*/


