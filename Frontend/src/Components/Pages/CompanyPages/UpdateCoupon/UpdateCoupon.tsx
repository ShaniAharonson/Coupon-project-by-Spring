import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate, useParams } from 'react-router-dom';
import axiosJWT from '../../../../util/axiosJWT';
import notify from '../../../../util/notify';
import { myStore } from '../../../../redux/Store';
import { updateCouponAction } from '../../../../redux/CompanyReducer';
import { Coupon } from '../../../Models/Coupon';
import { Category } from '../../../Models/Category';
import { useForm, SubmitHandler } from 'react-hook-form';
import { TextField, Button, Typography, ButtonGroup, InputLabel, Select, MenuItem } from '@mui/material';
import { checkData } from '../../../../util/chekData';
import { getSingleCouponAction } from '../../../../redux/CouponReducer';

export function UpdateCoupon(): JSX.Element {
    const navigate = useNavigate();
    const [coupon, setCoupon] = useState<Coupon | null>(null);
    const { id } = useParams();

    const { register, handleSubmit, formState: { errors }, reset } = useForm<Coupon>();

    useEffect(() => {
        checkData();
        if(myStore.getState().auth.userType !== "COMPANY"){
            navigate("/Page404");
            notify.error("No Acess!!!!!");

        }
        if (id) {
            console.log({ ...myStore.getState().coupon.allCoupons.find(item => item.id === +id) })
            const singleCoupon = myStore.getState().coupon.allCoupons.find(item => item.id === +id);
            if (singleCoupon) {
                setCoupon({ ...singleCoupon });
                reset(singleCoupon); // Reset form values with the coupon data
            }
        }
        if (myStore.getState().auth.token.length < 10) {
            navigate("/Login");
        }
    }, [id, reset, navigate]);

    const onSubmit: SubmitHandler<Coupon> = (data) => {
        const token = myStore.getState().auth.token;
        console.log("http://localhost:8080/updateCoupon", data,token);
        axiosJWT.put("http://localhost:8080/updateCoupon", data,
        {
            headers: {
                'Authorization': `${token}`
            }
        }
    )
            .then(res => {
                console.log("res data:" ,res.data);
                myStore.dispatch(updateCouponAction(res.data)); // Dispatch action with updated coupon
                notify.success("Coupon updated successfully!");
                navigate("/allCoupons");
            })
            .catch(err => {
                console.log("Error", err);
                console.error("Failed to update coupon:", err.response ? err.response.data : err);
                notify.error("Failed to update the coupon. " + (err.response ? err.response.data.message : ""));
            });
    };

    return (
        <div className="UpdateCoupon">
            <div className="Box" style={{ width: "70%", height: "68vh", overflowY: "scroll" }}>
                <form onSubmit={handleSubmit(onSubmit)}>
                    <Typography variant="h4" className="HeadLine">Update Coupon</Typography> <br/>
                    <TextField 
                        label="Title"
                        defaultValue={coupon?.title}
                        {...register("title", { required: "Title is required" })}
                        error={!!errors.title}
                        helperText={errors.title?.message}
                        fullWidth
                        margin="normal"
                    />
                    <TextField 
                        label="Description"
                        defaultValue={coupon?.description}
                        {...register("description")}
                        fullWidth
                        margin="normal"
                    />
                    <TextField
                        label="Start Date"
                        type="date"
                        defaultValue={coupon?.startDate}
                        {...register("startDate", { required: "Start Date is required" })}
                        error={!!errors.startDate}
                        helperText={errors.startDate?.message}
                        fullWidth
                        margin="normal"
                        InputLabelProps={{ shrink: true }}
                    />
                    <TextField
                        label="End Date"
                        type="date"
                        defaultValue={coupon?.endDate}
                        {...register("endDate", { required: "End Date is required" })}
                        error={!!errors.endDate}
                        helperText={errors.endDate?.message}
                        fullWidth
                        margin="normal"
                        InputLabelProps={{ shrink: true }}
                    />
                    <TextField 
                        label="Amount"
                        type="number"
                        defaultValue={coupon?.amount}
                        {...register("amount", { required: "Amount is required" })}
                        error={!!errors.amount}
                        helperText={errors.amount?.message}
                        fullWidth
                        margin="normal"
                    />
                    <TextField 
                        label="Price"
                        type="number"
                        defaultValue={coupon?.price}
                        {...register("price", { required: "Price is required" })}
                        error={!!errors.price}
                        helperText={errors.price?.message}
                        fullWidth
                        margin="normal"
                    />
                    <InputLabel id="category-label" >Select Category:</InputLabel>
                    <Select
                        labelId="category-label"
                        defaultValue={Category.electricity}
                        {...register("categoryId", {required:true})}
                        error={!!errors.categoryId}
                        fullWidth
                        
                    >
                        <MenuItem value={Category.electricity}>Electricity</MenuItem>
                        <MenuItem value={Category.food}>Food</MenuItem>
                        <MenuItem value={Category.restaurant}>Restaurant</MenuItem>
                        <MenuItem value={Category.vacation}>Vacation</MenuItem>
                    </Select>
                    <TextField 
                        label="Image"
                        defaultValue={coupon?.image}
                        {...register("image")}
                        fullWidth
                        margin="normal"
                    />
                    <hr />
                    <ButtonGroup variant="contained" fullWidth>
                        <Button type="submit" variant="contained" color="primary">Update</Button>
                        <Button variant="contained" color="error" onClick={() => navigate("/allCoupons")}>Cancel</Button>
                    </ButtonGroup>
                </form>
            </div>
        </div>
    );
}



// import React, { useEffect, useState } from 'react';
// import { useLocation, useNavigate, useParams } from 'react-router-dom';
// import axiosJWT from '../../../../util/axiosJWT';
// import notify from '../../../../util/notify';
// import { myStore } from '../../../../redux/Store';
// import { updateCouponAction } from '../../../../redux/CompanyReducer';
// import { Coupon } from '../../../Models/Coupon';
// import { Category } from '../../../Models/Category';
// import { useForm, SubmitHandler } from 'react-hook-form';
// import { TextField, Button, Typography, ButtonGroup, InputLabel, Select, MenuItem } from '@mui/material';
// import { checkData } from '../../../../util/chekData';
// import { getSingleCouponAction } from '../../../../redux/CouponReducer';


// export function UpdateCoupon(): JSX.Element {
//     const navigate = useNavigate();
//     const [coupon, setCoupon] = useState<Coupon>();
//     const [categories, setCategory] = useState<string[]>([])
//     const { id } = useParams();

//     const { register, handleSubmit, formState: { errors }, reset } = useForm<Coupon>();
//     useEffect(() => {
//         checkData();
//         let singleCoupon;
//         if (id) {
//             singleCoupon = myStore.getState().coupon.allCoupons.filter(item => item.id == +id)[0];
//             setCoupon(singleCoupon);
//         }
//         if (myStore.getState().auth.token.length < 10) {
//             navigate("/Login");
//         }
//         console.log(singleCoupon)
//     }, []);

//     const onSubmit: SubmitHandler<Coupon> = (data) => {
//         const token = myStore.getState().auth.token;

//         axiosJWT.put(`http://localhost:8080/updateCoupon/`, data, {
//             headers: {
//                 'Authorization': `Bearer ${token}`
//             }
//         })
//             .then(res => {
//                 myStore.dispatch(updateCouponAction(res.data)); // Dispatch action with updated coupon
//                 notify.success("Coupon updated successfully!");
//                 navigate("/allCoupons");
//             })
//             .catch(err => {
//                 console.error("Failed to update coupon:", err.response ? err.response.data : err);
//                 notify.error("Failed to update the coupon. " + (err.response ? err.response.data.message : ""));
//             });
//     };

//     return (
//         <div className="UpdateCoupon">
//             <div className="Box" style={{ width: "70%", height: "68vh", overflowY: "scroll" }}>
//                 <form onSubmit={handleSubmit(onSubmit)}>
//                     <Typography variant="h4" className="HeadLine">Update Coupon</Typography> <br/>
//                     Title: <input type="text" placeholder="Title" defaultValue={coupon?.title} {...register("title", { required: true })} />
//                     {errors.title?.type == "required" && <><br /><span style={{ color: "red" }}>Title is required</span></>}
//                     <br /><br />
//                     Description: <input type="text" placeholder="Description" defaultValue={coupon?.description} {...register("description")} />
//                     <br /><br />
//                     <label>Start Date: </label>
//                     <input type="date" placeholder="Start Date" defaultValue={coupon?.startDate} {...register("startDate", { required: true })} />
//                     <br /><br />
//                     <label>End Date: </label>
//                     <input type="date" placeholder="End Date" defaultValue={coupon?.endDate} {...register("endDate", { required: true })} />
//                     <br /><br />
//                     Amount: <input type="number" placeholder="Amount" defaultValue={coupon?.amount} {...register("amount", { required: true })} />
//                     <br /><br />
//                     Price: <input type="number" placeholder="Price" defaultValue={coupon?.price} {...register("price", { required: true })} />
//                     <br /><br />
//                     <label>Select Category:</label><br />
//                     <select defaultValue={coupon?.categoryId} {...register("categoryId")} >
//                         <option label='electricity' value={Category.electricity}> Electricity </option>
//                         <option value={Category.food} label='Food'></option>
//                         <option value={Category.restaurant} label='restaurant'></option>
//                         <option value={Category.vacation} label='vacation'></option>
//                     </select><br /><br />
//                     <input type="text" placeholder="Image" defaultValue={coupon?.image} {...register("image")} />
//                     <br /><br />
//                     <hr />
//                     <br />
//                     <ButtonGroup variant="contained" fullWidth>
//                         <Button type="submit" variant="contained" color="primary" >Update</Button>
//                         <Button variant="contained" color="error" onClick={() => { navigate("/allCoupons") }}>Cancel</Button>
//                     </ButtonGroup>
//                 </form>
//             </div>
//         </div>
//     );
// }
