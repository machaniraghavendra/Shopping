import React, { useEffect, useState } from 'react'
import "../Shirts/shirt.css"
import axios from "axios";

export default function Shirts() {
    const [shirt, setShirts] = useState([]);
    const [info, setInfo] = useState("");

    const fetch = () => {
        axios.get("http://localhost:8083/items/")
            .then((res) => { return (setShirts(res.data)) })
    }
    useEffect(() => {
        return (fetch())
    },[])
    return (
        <div className='container-fluid'>
            <h2 id='Dresses'>Dresses <i className="fa-duotone fa-shirt" style={{ fontFamily: "fontAwesome" }}></i></h2>

            {shirt.length == [] || !shirt.map(e => { e.itemType.toLowerCase().includes("Dresses".toLowerCase()) }) ?

                <div className='container-fluid'>
                    <h1>No Items Found !</h1>
                </div>

                :
                <>
                    <div className='container-fluid justify-content-center text-center' id='back-card-bg-menshirts'>
                        <h2 id='Shirts-men'><u>Shirts For Men</u></h2>
                        <div className="row row-cols-1 row-cols-md-4 gap-4 justify-content-center text-center">
                            {shirt.map(e => {
                                if (e.itemType.toLowerCase().includes("Dresses for men".toLowerCase())) {
                                    return (
                                        <div className='col row' key={e.itemId}>
                                            <div className="card" data-aos="zoom-in-right">
                                                <div className='card-header justify-content-end text-end'>
                                                    <button className='btn  m-2' onClick={() => {
                                                        axios.post("http://localhost:8081/cart/", {
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
                                                        data-bs-toggle="modal" data-bs-target="#exampleModal3" data-bs-whatever="@mdo"

                                                    ><i className='fa-solid fa-cart-shopping text-info'></i></button>
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
                                                        data-bs-toggle="modal" data-bs-target="#exampleModal3" data-bs-whatever="@mdo"
                                                    ><i className="fa-solid fa-heart text-danger"></i> </button>
                                                </div>
                                                <img src={e.itemImgUrl} className="card-img-top" alt="..." />
                                                <div className="card-body">
                                                    <h5 className="card-title">{e.itemName}</h5>
                                                    <p className="card-text"><b>Price : </b>{e.itemPrice}</p>
                                                    <p className="card-text"><b>Specfications : </b>{e.itemSpec}</p>
                                                    <p className="card-text"><b>Item Dimensions : </b>{e.itemDimensions}</p>
                                                </div>
                                                <a href='/mart' className='btn btn-info '>View More...</a>
                                               
                                            </div>
                                        </div>
                                    )
                                }
                            })
                            }
                        </div><br></br>
                        <a className='btn btn-info' href="/mart">View More Men Dresses....</a><br></br>
                        &nbsp;
                    </div>
                    <br ></br>
                    <div className='container-fluid justify-content-center text-center' id='back-card-bg-womenshirts'>
                        <h2 id='Shirts-women'><u>Shirts For Women</u></h2>
                        <div className="row row-cols-1 row-cols-md-4 gap-4 justify-content-center text-center">
                            {shirt.map(e => {
                                if (e.itemType.toLowerCase().includes("Dresses for Women".toLowerCase())) {
                                    return (
                                        <div className='col row' key={e.itemId}>
                                            <div className="card" data-aos="zoom-in-right">
                                            <div className='card-header justify-content-end text-end'>
                                                <button className='btn  m-2' onClick={() => {
                                                    axios.post("http://localhost:8081/cart/", {
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
                                                    data-bs-toggle="modal" data-bs-target="#exampleModal3" data-bs-whatever="@mdo"

                                                ><i className='fa-solid fa-cart-shopping text-info'></i></button>
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
                                                    data-bs-toggle="modal" data-bs-target="#exampleModal3" data-bs-whatever="@mdo"
                                                ><i className="fa-solid fa-heart text-danger"></i> </button>
                                            </div>
                                                <img src={e.itemImgUrl} className="card-img-top" alt="..." />
                                                <div className="card-body">
                                                    <h5 className="card-title" id={e.itemName}>{e.itemName}</h5>
                                                    <p className="card-text"><b>Price : </b>{e.itemPrice}</p>
                                                    <p className="card-text"><b>Specfications : </b>{e.itemSpec}</p>
                                                    <p className="card-text"><b>Item Dimensions : </b>{e.itemDimensions}</p>
                                                </div>
                                                <a href='/mart' className='btn btn-info '>View More...</a>
                                              
                                            </div>
                                        </div>
                                    )
                                }
                            })
                            }
                        </div><br></br>
                        <a className='btn btn-info' href="/mart">View More Women Dresses....</a><br></br>
                        &nbsp;
                    </div>
                </>

            }
            <hr />
            <div className="modal fade" id="exampleModal3" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
        </div>
    )
}
