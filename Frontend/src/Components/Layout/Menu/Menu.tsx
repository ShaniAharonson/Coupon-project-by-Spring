import { NavLink } from "react-router-dom";
import "./Menu.css";
import { useState } from "react";
import { myStore } from "../../../redux/Store";

export function Menu(): JSX.Element {
    const [totalCompanies, setTotal] = useState(0);
    const [totalCustomers, setTotalCustomers] = useState(0);
    const [isAdmin, setAdmin] = useState(false);
    const [isCompany, setCompany] = useState(false);
    const [isCustomer, setCustomer] = useState(false);


    myStore.subscribe(() => {
        setTotal(myStore.getState().admin.allCompanies.length);
        setTotalCustomers(myStore.getState().admin.allCustomers.length);
        setAdmin(myStore.getState().auth.userType == "ADMIN");
        setCompany(myStore.getState().auth.userType == "COMPANY");
        setCustomer(myStore.getState().auth.userType== "CUSTOMER");
    });

    const geustMenu = () => {
        return (
            <>
                <br />
                <NavLink to="/allCoupons" style={{ color: "Highlight" }}>Home Page</NavLink> <br /> <br />
            </>
        )
    }

    const adminMenu = () => {
        return (
            <>
                <NavLink to="/addCompany"> Add Company </NavLink> <br />
                <NavLink to="/deleteCompany/:id"> Delete Company </NavLink> <br />
                <NavLink to="/allCompanies"> All Companies </NavLink> <br />

                <hr />
                <NavLink to="/addCustomer"> Add Customer </NavLink> <br />
                <NavLink to="/deleteCustomer/:id"> Delete Customer </NavLink> <br />
                <NavLink to="/allCustomers"> All Customers </NavLink> <br />

                <hr />
                Total Companies: {totalCompanies} <br />
                Total Customers: {totalCustomers}
            </>
        )
    }

    const companyMenu = () => {
        return (
            <>
                <br />
                <NavLink to="/addCoupon"> Add Coupon </NavLink> <br />
                <NavLink to="/deleteCoupon"> Delete Coupon </NavLink> <br />
                <NavLink to="/companyCoupons/:id"> All Comapny Coupons </NavLink> <br />
                <NavLink to="/companyCouponCategory"> Coupons By Category </NavLink> <br />
                <NavLink to="/companyCouponsPrice"> Coupons By Price </NavLink> <br />
                <NavLink to="/companyDetails"> Company Details </NavLink>
            </>
        )
    }

    const customerMenu = () => {
        return (
            <>
                <NavLink to="/customerCoupons"> All Customer Coupons </NavLink><br />
                <NavLink to="customerCouponsCategory">Coupons By Category</NavLink><br />
                <NavLink to="customerCouponsPrice" >Coupons By Price</NavLink><br />
                <NavLink to="/customerDetails"> Company Details </NavLink><br />

            </>
        )
    }

    return (
        <div className="Menu">
            {geustMenu()}
            <hr />

            {isAdmin && adminMenu()}
            {isCompany && companyMenu()}
            {isCustomer && customerMenu()}

        </div>
    );
}