import React, { useEffect, useState } from 'react'
import axios from "axios"
import img from "../imgbin_shopping-bag-shopping-cart-computer-icons-png.png"
import { Link } from "react-router-dom";
import "../Cart/Cart.css"
import Footer from '../Footer/Footer';

export default function Cartpage() {

    const [search, setSearch] = useState("");

    const [data, setData] = useState([]);

    const [findvalue, setFindvalue] = useState("");

    const [find, setFind] = useState(false);

    const [info, setInfo] = useState("");

    const [totalAmount, setTotalAmount] = useState("");

    var count = 0;

    const fetch = () => {
        axios.get("http://localhost:8081/cart/")
            .then((res) => { return (setData(res.data)) })

        axios.get("http://localhost:8081/cart/total").then(res => { return (setTotalAmount(res.data)) })
    }

    const check = () => {
        let top = document.querySelector(".check");
        let title = document.querySelector(".check .container-fluid h1");
        let title2 = document.querySelector(".check .container-fluid h2");

        let scroll = document.querySelector(".scroll-up");
        if (document.body.scrollTop > 150 || document.documentElement.scrollTop > 150) {
            top.classList.add("fixed-top");
            title.innerHTML = ' <img src="https://media.istockphoto.com/vectors/shopping-bag-flat-icon-pixel-perfect-for-mobile-and-web-vector-id1145783156?k=20&m=1145783156&s=612x612&w=0&h=RJdFiHDeaQJt3KbyIfJmWS12iQrD63DUCMWPrFLumwk=" alt="" width="35" height="35" className="d-inline-block align-text-top" />&nbsp;Shopping Mart'
            title2.innerHTML = ""
        }
        if (document.body.scrollTop > 150 || document.documentElement.scrollTop > 150) {
            scroll.style.display = "block";
            title2.classList.remove("d-none")
        }
        else {
            top.classList.remove("fixed-top");
            title.innerHTML = "Contents";
            scroll.style.display = "none";
        }
    }

    useEffect(() => {
        window.onscroll = () => check();
        return (fetch())
    }, [])

    return (

        <div className='container-fluid'>
            {/* Header */}
            < header className='cart-head' >
                <div className='container-fluid '>
                    <nav className="navbar bg-none navbar-expand-lg sticky-top">
                        <div className="container-fluid ">
                            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                                <span className="navbar-toggler-icon"></span>
                            </button>
                            <Link to="/mart" className='nav-link' >  <h1 className="navbar-brand" >
                                <img src={img} alt="" width="30" height="30" className="d-inline-block align-text-top" />
                                &nbsp;Shopping Mart
                            </h1></Link><br></br>
                            <div className="collapse navbar-collapse justify-content-end gap-2" id="navbarTogglerDemo03">
                                <br></br>
                                <button className="btn btn-outline-danger  justify-content-end " data-bs-toggle="tooltip" data-bs-placement="bottom" data-bs-title="Tooltip on bottom"
                                    onClick={() => {
                                        return (localStorage.removeItem("Raghu"),
                                            window.location.reload())
                                    }}><i className="fa-solid fa-power-off"></i>
                                </button>&nbsp;
                            </div>
                        </div>
                    </nav>

                    <br></br>

                    <nav className="navbar navbar-expand-lg check bg-light">
                        <div className="container-fluid  ">
                            <button className="navbar-toggler " type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                                <span className="navbar-toggler-icon"></span>
                            </button>
                            <h2 className=' d-sm-block d-md-none d-lg-none navbar-brand'></h2>

                            <h1 className="navbar-brand" ></h1>
                            <div className="collapse navbar-collapse " id="navbarTogglerDemo02">
                                <ul className="navbar-nav me-auto mb-2 mb-lg-0  ">
                                    <div className="container-fluid text-center">
                                        <div className="row row-cols-3 row-cols-lg-5 g-2 g-lg-5 ">
                                            <li className="nav-item ">
                                                <a className=" d-lg-none nav-link" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasResponsive" aria-controls="offcanvasResponsive"><h5><i className='fa-solid fa-list'></i> Browse contents</h5></a>
                                            </li>
                                            <li className="nav-item">
                                                <Link className="nav-link text-dark" to="/wishlist"><h5> Wishlist</h5></Link>
                                            </li>
                                        </div>
                                    </div>
                                </ul>
                                <div className="d-flex justify-content-center" >
                                    <div className="search btn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">
                                        <i className="fa-solid fa-search"></i>&nbsp;
                                        Search...&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </div>
                                </div>
                            </div>
                        </div>
                    </nav>
                </div>
            </header >
            <div className='container-fluid middle'>
                <div className='cart-aside d-none d-md-none d-lg-block'>
                    <aside className=' '>
                        <div className="offcanvas-lg offcanvas-start alert alert-info" tabIndex="-1" id="offcanvasResponsive" aria-labelledby="offcanvasResponsiveLabel">
                            <div className="alert alert-warning d-none d-lg-block"><i className='fa-solid fa-circle-dot'></i> Browse Contents </div>
                            <div className="offcanvas-header">
                                <h5 className="offcanvas-title text-dark" id="offcanvasResponsiveLabel">Browse contents</h5>
                                <button type="button" className="btn-close" data-bs-dismiss="offcanvas" data-bs-target="#offcanvasResponsive" aria-label="Close"></button>
                            </div>
                            <div className="offcanvas-body bg-dark ">
                                <ul className="navbar-nav me-auto mb mb-lg-0  listss">
                                    <li className="nav-item">
                                        <Link className="nav-link " to="/wishlist"><i className="fa-solid fa-heart text-danger"></i> Wishlist</Link>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </aside>
                </div>
                <div className='cart-body float-md-left float-lg-right'>
                    {data.length == [] ?
                        <div className='container-fluid cart-no'><br></br>
                                                        <h1>No Items Found in Cart !</h1>

                            <img className='img-fluid cart-no-img' src='https://img.freepik.com/free-photo/portrait-sad-woman-holding-shopping-bags-bank-card-isolated-blue-background_1258-80590.jpg?w=900&t=st=1661337619~exp=1661338219~hmac=2216603151e8e22d07a13935e4d02c5b9629f1482b776df503c439b83528628f' width="70%" />
                        </div>
                        :
                        <div className='container-fluid '>
                            <div className="  row row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-3 gap-4 justify-content-center text-center ">
                                {data.map(e => {
                                    return (
                                        <div className=' col row ' key={e.itemId}>&nbsp;
                                            <div className="card" data-aos="fade-up" >

                                                <div className='card-header justify-content-end text-end'>
                                                    <button className='btn  m-2' onClick={() => {
                                                        axios.delete("http://localhost:8081/cart/" + e.itemId).then((res) => { return (setInfo(res.data), fetch()) })
                                                    }}
                                                        data-bs-toggle="modal" data-bs-target="#exampleModal2" data-bs-whatever="@mdo"
                                                    ><i className='fa-solid fa-trash text-danger'></i></button>
                                                    <button className='btn ' onClick={() => {
                                                        axios.post("http://localhost:8082/fav/", {
                                                            "itemId": e.itemId,
                                                            "itemName": e.itemName,
                                                            "itemDesc": e.itemDesc,
                                                            "itemPrice": e.itemPrice,
                                                            "itemType": e.itemType,
                                                            "itemDimensions": e.itemDimensions,
                                                            "itemImgUrl": e.itemImgUrl,
                                                            "itemSpec": e.itemSpec
                                                        }, []).then((res) => { return (setInfo(res.data)) })
                                                    }}
                                                        data-bs-toggle="modal" data-bs-target="#exampleModal2" data-bs-whatever="@mdo"
                                                    ><i className="fa-solid fa-heart text-danger"></i> </button>
                                                </div>
                                                <img src={e.itemImgUrl} className="card-img-top" alt="..." />

                                                <div className="card-body">
                                                    <h5 className="card-title" id={e.itemName}>{e.itemName}</h5>
                                                    <p className="card-text">{e.itemPrice}</p>
                                                    <p className="card-text">{e.itemSpec}</p>
                                                </div>
                                                <a href='#' className='btn btn-info '>View More...</a>
                                            </div>
                                        </div>
                                    )
                                })
                                }
                            </div><br></br>
                            &nbsp;
                            <div className='card' style={{ height: "10%" }}>
                                <div className='card-footer'>
                                    <h5>List of products in cart :</h5>
                                    {data.map(e => {
                                        return (
                                            <div key={e.itemId}>
                                                <li >
                                                    {e.itemName} = {e.itemPrice} -&gt;
                                                    <button className='btn btn-outline-danger m-2' onClick={() => {
                                                        axios.delete("http://localhost:8081/cart/" + e.itemId).then((res) => { return (setInfo(res.data), fetch()) })
                                                    }}
                                                        data-bs-toggle="modal" data-bs-target="#exampleModal2" data-bs-whatever="@mdo">
                                                        <i className='fa-solid fa-trash '></i></button>
                                                    <a className='btn btn-warning' href={e.prodcuturl}> Buy now</a>

                                                </li>&nbsp;

                                            </div>
                                        )
                                    })}<br></br>
                                </div>
                                <b className='justify-content-end text-end'> Total products amount =<span className='text-success'> {totalAmount} </span>-&gt; <a className='btn btn-warning' > Buy now</a></b>
                            </div>

                        </div>
                    }<br></br>

                </div>
            </div>
            {/* Footer */}

            <Footer />

            {/* scroll Button */}

            <div className="container-fluid" >
                <button className="btn btn-primary align-text-center scroll-up"
                    onClick={() => {
                        return (document.documentElement.scrollTop = 0,
                            document.body.scrollTop = 0)
                    }}>
                    <h4><i className="fa-solid fa-angle-up"></i></h4></button>
            </div>

            {/* Popup */}
            <div className="modal fade" id="exampleModal2" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-body">
                            <h4>{info}</h4>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

            {/* Search bar */}

            <div className="modal fade " id="exampleModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div className="modal-dialog modal-fullscreen-lg-down modal-dialog-scrollable modal-lg ">
                    <div className="modal-content bg-info">
                        <div className="modal-header ">
                            <h5 className="modal-title text-end" id="exampleModalLabel"></h5>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            <form>
                                <div className="form-floating mb-3 ">
                                    <input type="search"
                                        className="form-control"
                                        onChange={(e) => { return (setSearch(e.target.value), setFindvalue(count)), setFind(true) }}
                                        onKeyUp={() => { return (setFindvalue(count), setFind(true)) }}
                                        id="floatingInput"
                                        placeholder="Search here..." />
                                    <label htmlFor="floatingInput">Search/Name...</label>
                                    {!(search != "") ? ""
                                        :
                                        <>
                                            {find == true ?
                                                <>
                                                    <p className="container-fluid"><b>Search results :</b>Found {findvalue} </p>
                                                </> : ""}
                                        </>}
                                </div>
                            </form>
                            <div className="row row-cols-1 row-cols-sm-3 row-cols-md-4 row-cols-lg-3 gap-4 justify-content-center text-center ">
                                {data.filter((val) => {
                                    if (search == "") {
                                        count = 0;
                                        return null;
                                    }
                                    if (val.itemName.toLowerCase().includes(search.toLowerCase())) {
                                        return val
                                    }
                                }).map((e) => {
                                    count++;
                                    return (
                                        <div className=' col row ' key={e.itemId}>&nbsp;
                                            <div className="card " data-aos="fade-up" >
                                                <div className='card-header justify-content-end text-end'>
                                                    <button className='btn  m-2' onClick={() => {
                                                        axios.delete("http://localhost:8081/cart/" + e.itemId).then((res) => { return (setInfo(res.data), fetch(), setFindvalue(count)) })
                                                    }}><i className='fa-solid fa-trash text-danger'></i>
                                                    </button>
                                                    <button className='btn ' onClick={() => {
                                                        axios.post("http://localhost:8082/fav/", {
                                                            "itemId": e.itemId,
                                                            "itemName": e.itemName,
                                                            "itemDesc": e.itemDesc,
                                                            "itemPrice": e.itemPrice,
                                                            "itemType": e.itemType,
                                                            "itemDimensions": e.itemDimensions,
                                                            "itemImgUrl": e.itemImgUrl,
                                                            "itemSpec": e.itemSpec
                                                        }, []).then((res) => { return (setInfo(res.data)) })
                                                    }}
                                                        data-bs-toggle="modal" data-bs-target="#staticBackdrop" data-bs-whatever="@mdo"
                                                    ><i className="fa-solid fa-heart text-danger"></i> </button>
                                                </div>
                                                <img src={e.itemImgUrl} className="card-img-top" alt="..." />
                                                <div className="card-body">
                                                    <h5 className="card-title" id={e.itemName}>{e.itemName}</h5>
                                                    <p className="card-text">{e.itemPrice}</p>
                                                    <p className="card-text">{e.itemSpec}</p>
                                                </div>
                                                <a href='#' className='btn btn-info '>View More...</a>
                                            </div>
                                        </div>
                                    )
                                })
                                }
                            </div>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn=outline-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div >
        </div>
    )
}
