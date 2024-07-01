import "./Header.css";
import logo from "../../../Assests/printable-coupons.jpg"
import { useNavigate } from "react-router-dom";
import { Button, ButtonGroup, Typography } from "@mui/material";
import { useEffect, useState } from "react";
import { myStore } from "../../../redux/Store";
import { logoutAction } from "../../../redux/authReducer";
import { checkData } from "../../../util/chekData";

export function Header(): JSX.Element {
    const [isLogged, setLogged] = useState(false);
    const [userName, setName] = useState("");

    useEffect(()=>{
            checkData();
    },[])
    myStore.subscribe(() => {
        setName(myStore.getState().auth.name);
        setLogged(myStore.getState().auth.isLogged);
    })

    const navigate = useNavigate();
    return (
        <div className="Header">
            <div className="logo">
                <img src={logo} width={150}  />
            </div>
            <div>
                <Typography variant="h4" className="HeadLine">Coupons Website</Typography>
            </div>
            <div className="login">
                Hello {userName} <br />
                <ButtonGroup variant="contained" fullWidth>
                    <Button type="submit" color={isLogged ? "secondary" : "info"}
                        onClick={() => {
                            if (isLogged) {
                                sessionStorage.removeItem("jwt");
                                myStore.dispatch(logoutAction());
                            //    myStore.dispatch(clearAdminAction)
                            //    myStore.dispatch(clearCompanyAction)
                            //    myStore.dispatch(clearCustomerAction)
                            //    myStore.dispatch(clearCouponAction)
                                navigate("/")
                            } else {
                                navigate("/Login")
                            }
                        }}>{isLogged ? "Logout" : "Login"}</Button>
                    {!isLogged && <Button value="Register" color="secondary" onClick={() => navigate("/addCustomer")}>Register</Button>};
                </ButtonGroup>
            </div>
        </div>
    );
}
