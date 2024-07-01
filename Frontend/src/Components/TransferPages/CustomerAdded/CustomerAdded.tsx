import { useNavigate } from "react-router-dom";
import "./CustomerAdded.css";

export function CustomerAdded(): JSX.Element {
    const navigate = useNavigate();

    return (
        <div className="CustomerAdded">
            <div className="content">
			<h1>Customer is added successfuly!!</h1>
            <p>Your customer has been added to our system.</p>
            <button className="homeButton" onClick={() => navigate("/")}>Go to Home Page</button>

            </div>
        </div>
    );
}
