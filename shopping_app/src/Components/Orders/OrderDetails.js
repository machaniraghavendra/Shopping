import React, { useEffect, useState } from 'react'
import "../Orders/Orders.css"
import axios from "axios"
import { Link, useNavigate } from "react-router-dom";
import Footer from '../Footer/Footer';
import img from "../imgbin_shopping-bag-shopping-cart-computer-icons-png.png"
import ChatBot from '../ChatBot/ChatBot';

export default function OrderDetails(props) {

    const [user, setUser] = useState([]);

    const [order, setOrder] = useState([]);

    const fetchOrders = () => {
        axios.get("http://localhost:8083/orders/").then((res) => { setOrder(res.data) });
    }

    useEffect(() => {
        sessionStorage.getItem("dark") ? document.body.style = " background: linear-gradient(140deg, #050505 60%, rgb(22, 14, 132) 0%)"
            : document.body.style = "background: radial-gradient( #f5ff37, rgb(160, 255, 97))"
        document.title = "Orders | Shopping Mart"
        axios.get("http://localhost:8080/user/" + props.user).then(a => { return (setUser(a.data)) })
        fetchOrders()
        let card = document.getElementsByClassName("card-color");
        if (sessionStorage.getItem("dark") == "yes") {
            for (const cards of card) {
                cards.classList.add("bg-dark")
                cards.classList.add("text-light")
                cards.classList.remove("bg-light")
                cards.classList.remove("text-dark")
            }
        } else {
            for (const cards of card) {
                cards.classList.remove("bg-dark")
                cards.classList.add("bg-light")
                cards.classList.add("text-dark")
                cards.classList.remove("text-light")
            }
        }
    }, []);

    return (
        <div>
            <div className='container-fluid' style={{ fontSize: "13px" }}>
                {/* Header */}
                < header className='cart-head' >
                    <div className='container-fluid '>
                        <nav className="navbar bg-none navbar-expand-lg sticky-top">
                            <div className="container-fluid ">
                                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                                    <i className="fa-thin fa-arrow-left btn m-1" style={{ fontFamily: "fontAwesome" }} onClick={() => { return (window.history.back()) }}></i>
                                    <span className="navbar-toggler-icon"></span>
                                </button>
                                <i className="fa-thin fa-arrow-left btn m-1 d-none d-lg-block" style={{ fontFamily: "fontAwesome" }} onClick={() => { return (window.history.back()) }}></i>
                                <Link to="/mart" className='nav-link' >  <h1 className="navbar-brand" >
                                    <img src={img} alt="" width="30" height="30" className="d-inline-block align-text-top" />
                                    &nbsp;Shopping Mart
                                </h1></Link><br></br>
                                <div className="collapse navbar-collapse justify-content-end gap-2" id="navbarTogglerDemo03">
                                    <br></br>
                                    <div className="btn-group">
                                        <button type="button" className="btn btn-none dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" aria-expanded="false">
                                            <i className="fa-solid fa-user"></i>&nbsp; {user.userName}
                                        </button>
                                        <ul className="dropdown-menu bg-secondary-warning dropdown-menu-lg-end user">
                                            <li><Link className="dropdown-item" to={"/profile/settings"}><i className='fa-solid fa-gear'></i> Settings</Link></li>
                                            <li>
                                                <a className="dropdown-item text-center">
                                                    <button className="btn btn-outline-danger  justify-content-end " data-bs-toggle="modal" data-bs-target="#exampleModal3" data-bs-whatever="@fat"
                                                    ><i className="fa-solid fa-power-off"></i> Sign out
                                                    </button>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>&nbsp;
                                </div>
                            </div>
                        </nav>
                    </div>
                </header>
                <div className='container my-4'>
                    <div className='card-color p-3'>
                        {order.map(a => {
                            return (
                                <div key={a.orderId}>
                                    <small className='text-muted'>Order id : {a.uuidId}</small>

                                    <div className='row'>
                                        <div className='col-12 col-md-8'>   <hr></hr>
                                            <h4>{a.itemEntity.map(e => { return (e.itemName) })}</h4>
                                            <p className='p-3'><b> Price : {a.itemEntity.map(e => { return (e.itemPrice) })}</b></p>
                                            <h6>Order Details</h6>
                                            <div className='px-3'>
                                                <p>Ordered on  {a.orderedOn}</p>
                                                <p>At the time of {a.orderedAt} sec</p>
                                            </div>
                                            <h6>Delivery Details</h6>
                                            <div className='px-3'>
                                                <p>Name : {a.firstName + " " + a.lastName}</p>
                                                <p>Email address : {a.emailAddress}</p>
                                                <p>Mobile Number : {a.phoneNumber}</p>
                                                <p>Address : {a.deliveryAddress}</p>
                                                <p>Pincode : {a.pincode}</p>
                                                <p>Order Quantity : {a.orderQuantity}</p>
                                                <p>Payment type : {a.paymentType}</p>
                                            </div>
                                            <hr></hr>
                                        </div>
                                        <div className='col-4'>
                                            <img src={a.itemEntity.map(e => { return (e.itemImgUrl) })} className="img-fluid rounded-start d-lg-block d-none float-end " alt={a.itemEntity.map(e => { return (e.itemName) })} />
                                        </div>
                                    </div>
                                </div>
                            )
                        })}
                    </div>
                </div>

                {/* Logout popup */}
                <div className="modal fade " id="exampleModal3" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content logout-model">
                            <div className="modal-header">
                                <h5 className="modal-title " id="exampleModalLabel"><img src={img} alt="" width="30" height="30" className="d-inline-block align-text-top" /> Shopping mart</h5>
                                <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div className="modal-body text-center">
                                <h5>Conform to logout</h5>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-outline-success" data-bs-dismiss="modal">No</button>
                                <button type="button" className="btn btn-outline-danger"
                                    onClick={() => {
                                        return (localStorage.removeItem("currentuser"),
                                            localStorage.removeItem("Raghu"),
                                            window.location.reload())
                                    }}
                                >Yes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <ChatBot />
            
        </div>
    )
}