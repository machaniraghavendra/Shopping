import React, { useEffect, useState } from 'react'
import "../Mobiles/Mob.css";
import axios from "axios";

export default function Mobiles() {

    const [mobiles, setMobiles] = useState([]);
    const [info, setInfo] = useState("");
    const fetch = () => {
        axios.get("http://localhost:8083/items/")
            .then((res) => { return (setMobiles(res.data)) })
    }
    useEffect(() => {
        return (fetch())
    },[])
    return (
        <div className='container-fluid'>
            <h2 id='Mobiles'>Mobiles <i className="fa-duotone fa-mobile" style={{ fontFamily: "fontAwesome" }}></i></h2>
            {mobiles.length == [] || !mobiles.map(e => { e.itemType.toLowerCase().includes("Mobile".toLowerCase()) }) ?
                <div className='container-fluid'>
                    <h1>No Items Found !</h1>
                </div>
                :
                <div className='container-fluid justify-content-center text-center' id='back-card-bg-mob' >
                    <div className="  row row-cols-1 row-cols-md-4 gap-4 justify-content-center text-center ">
                        {mobiles.map(e => {
                            if (e.itemType.toLowerCase().includes("Mobile".toLowerCase())) {
                                return (
                                    <div className=' col row ' key={e.itemId}>&nbsp;
                                        <div className="card " data-aos="fade-up" >

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
                                                    data-bs-toggle="modal" data-bs-target="#exampleModal1" data-bs-whatever="@mdo"

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
                                                    data-bs-toggle="modal" data-bs-target="#exampleModal1" data-bs-whatever="@mdo"
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
                            }
                        })
                        }
                    </div><br></br>
                    <a className='btn btn-info' href="#">View More Mobiles....</a><br></br>
                    &nbsp;
                </div>
            }
            <hr />
            <div className="modal fade" id="exampleModal1" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
