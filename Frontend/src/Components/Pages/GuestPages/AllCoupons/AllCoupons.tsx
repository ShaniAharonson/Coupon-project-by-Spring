import { Typography } from "@mui/material";
import "./AllCoupons.css";
import { useEffect, useState } from "react";
import { Coupon } from "../../../Models/Coupon";
import { useNavigate } from "react-router-dom";
import { checkData } from "../../../../util/chekData";
import { myStore } from "../../../../redux/Store";
import axiosJWT from "../../../../util/axiosJWT";
import { getAllCouponsAction } from "../../../../redux/CouponReducer";
import { SingleCoupon } from "../SingleCoupon/SingleCoupon";
import axios from "axios";

export function AllCoupons(): JSX.Element {
    //react hooks => useState , useEffect
    const [coupons, setList] = useState<Coupon[]>([]);
    const navigate = useNavigate();
    //get song list from backend
    useEffect(() => {
        let recivedList: Coupon[] = [];
      
        if (myStore.getState().coupon.allCoupons.length <= 1) {
            axios.get("http://localhost:8080/getAllCoupons")
                .then(result => {
                    console.log("data:", result);
                    for (let index = 0; index < result.data.length; index++) {
                        recivedList.push(new Coupon(
                           result.data[index].id,
                           result.data[index].companyId,
                           result.data[index].categoryId,
                           result.data[index].title,
                           result.data[index].description,
                           result.data[index].startDate,
                           result.data[index].endDate,
                           result.data[index].amount,
                           result.data[index].price,
                           result.data[index].image
                        ));
                    }                   
                    myStore.dispatch(getAllCouponsAction(recivedList));
                    setList(myStore.getState().coupon.allCoupons);
                })
                .catch(err=>{
                    navigate("/Login")
                });
        } else {
            setList(myStore.getState().coupon.allCoupons);
        }
    }, [myStore.getState().coupon.allCoupons])


    return (
        <div className="AllCoupons"  style={{ width: "100%", height: "75vh", overflowY: "scroll" }}>
			<Typography variant="h5" color={"coral"}>All Coupons</Typography>
            {coupons.map(item => <SingleCoupon key={item.id} coupon={item}/>)}
        </div>
    );
}
