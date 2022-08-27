import React, { useEffect, useState } from 'react'
import axios from "axios";
import { Link, useNavigate } from 'react-router-dom';
import "../Login/css.css"
import img from "../imgbin_shopping-bag-shopping-cart-computer-icons-png.png"

export default function Login() {

    const [user, setUser] = useState({ userPassword: "", userEmail: "" });

    const [formErrors, setFormErrors] = useState({ password: "", userEmail: "" });

    const [isSubmit, setIsSubmit] = useState([]);

    const [showToast, setShowToast] = useState(false);

    const [info, setInfo] = useState([]);


    const nav = useNavigate();

    const set = (e) => {
        const { name, value } = e.target;
        setUser({ ...user, [name]: value });
    }

    const check = () => {
        if (isSubmit == true) {
            if (formErrors.userEmail == "" && formErrors.password == "") {
                axios.get("http://localhost:8080/user/" + user.userEmail + "/" + user.userPassword)
                    .then(res => {
                        if (res.data) {
                            { localStorage.setItem("Raghu", "raghu") };
                            if (localStorage.getItem("Raghu")) {
                                return (setInfo(""),
                                    setShowToast(true), timeout(),
                                    nav("/mart"),
                                    window.location.reload()
                                )
                            }
                        }
                        setIsSubmit(false)
                        if (!res.data) {
                            return ((setInfo("You don't have account with us , if already created check password once !"),
                                setShowToast(true), timeout()))
                        }
                    })
            }
        }
    }


    const timeout = () => {
        setTimeout(() => {
            setShowToast(false);
        }, 6000);
    }


    const handleSubmit = (e) => {
        e.preventDefault();
        setFormErrors(validate(user));
    }

    const validate = (user) => {
        const errors = {}
        const regex = /^[a-zA-Z0-9+._-]+@[a-zA-Z]+[.com]+/;

        if (!user.userEmail) {
            errors.userEmail = "Email is Required";
        } else if (!regex.test(user.userEmail)) {
            errors.userEmail = "Email is not a email format"
        } else {
            errors.userEmail = "";
        }

        if (!user.userPassword) {
            errors.password = "Password is required"
        } else if (user.userPassword.length < 4) {
            errors.password = "Password must be greater than 4 characters"
        } else if (user.userPassword.length > 10) {
            errors.password = "Password must be less than 10 characters"
        } else {
            errors.password = "";
        }
        if (formErrors.userEmail == "" && formErrors.password == "") {
            setIsSubmit(true);
        }
        return errors;
    }

    return (
        <section className="vh-100 py-5 position-absolute" style={{ backgroundColor: "#9A616D", width: "100%", height: "100%" }}>

            <div className='container-fluid  h-100 '>
                <div className="row d-flex justify-content-center align-items-center h-100 ">
                    <div className="col col-xl-10">
                        <div className="card mb-3 justify-content-center h-100" data-aos="zoom-in-down">
                            <div className="row g-0">
                                <div className="col-md-4 d-md-block d-none">
                                    <img src="https://img.freepik.com/free-photo/smiling-woman-shopping_329181-9170.jpg?w=360&t=st=1660925013~exp=1660925613~hmac=05ffabb4065893df622631e0bdf8329d18ca223076e6eb7e44e3363ec3ce375b" className="img-fluid signimg rounded-start" alt="Logo" />
                                </div>
                                <div className="col-md-8 col-lg-7 d-flex align-items-center" >
                                    <div className="card-body">
                                        <h2 className="card-title">
                                            <img src={img} alt="" width="35" height="35" className="d-inline-block align-text-top" /> Shopping Mart
                                        </h2>

                                        <form onSubmit={handleSubmit} method="get" action="http://localhost:8080/login">

                                            <h5 className="fw-normal mb-3 pb-3" style={{ letterSpacing: " 1px" }}>Sign into your account</h5>

                                            <div className="form-outline mb-4 form-floating mb-3">
                                                <input type="email" id="floatingInput"
                                                    className="form-control form-control-lg"
                                                    name='userEmail'
                                                    onChange={set}
                                                    value={user.userEmail}
                                                    onInput={handleSubmit}
                                                    placeholder="Email address" />
                                                <label className="form-label" htmlFor="floatingInput">Email address</label>
                                                <span className='text-danger'>{formErrors.userEmail}</span>
                                            </div>

                                            <div className="form-outline mb-4 form-floating">
                                                <input type="password" id="floatingPassword"
                                                    className="form-control form-control-lg"
                                                    name='userPassword'
                                                    value={user.userPassword}
                                                    onChange={set}
                                                    onInput={handleSubmit}
                                                    placeholder="Password" />
                                                <label className="form-label" htmlFor="floatingPassword">Password</label>
                                                <span className='text-danger'>{formErrors.password}</span>
                                            </div>

                                            <div className="pt-1 mb-4 text-center">
                                                <button className="btn btn-dark btn-lg btn-block " type="submit"
                                                    onClick={() => {
                                                        return (
                                                            check()
                                                        )
                                                    }}
                                                >Login</button>
                                            </div>

                                            <Link className="small text-muted" to="/login/forgot/password">Forgot password?</Link>

                                            <p className="mb-5 pb-lg-2" style={{ color: "#393f81" }}>Don't have an account?
                                                <Link to="/signup"
                                                    style={{ color: "#393f81" }}>Register here
                                                </Link>&nbsp;
                                                <a className='btn' onClick={() => { return (window.history.go(-1)) }}>Click here to go back</a>
                                            </p>

                                            <a href="#!" className="small text-muted">Terms of use.</a>
                                            <a href="#" className="small text-muted m-3">Privacy policy</a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            {showToast && <div class="toast  fade show" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="d-flex">
                    <div class="toast-body">
                        {info}
                        <div class="mt-2 pt-2">
                            <button type="button" class="btn btn-outline-light btn-sm" data-bs-dismiss="toast">Ok</button>
                        </div>
                    </div>

                </div>
            </div>}
        </section>
    )
}
