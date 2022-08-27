import { BrowserRouter as Router, Link, Route, Routes } from "react-router-dom";
import './App.css';
import Footer from './Components/Footer/Footer';
import Login from "./Components/Login/Login";
import SignUp from "./Components/Login/SignUp";
import MainPage from './Components/MainPage/Mainpage';
import Mobiles from './Components/Mobiles/Mobiles';
import Shirts from './Components/Shirts/Shirts';
import Sports from './Components/Sports/Sports';
import Trending from './Components/Trending/Trending';
import MainpageAlog from "./Components/MainPage/MainnpageAlog"
import ErrorPage from "./Components/Error/ErrorPage";
import Cartpage from "./Components/Cart/Cartpage";
import Wishlist from "./Components/WishList/Wishlist";
import ForgotPass from "./Components/Login/ForgotPass";

function App() {
  if (localStorage.getItem("Raghu")) {
    return (
      <div className="App">
        <Router>
          <Routes>
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<SignUp />} />
            <Route path="/cart" element={<Cartpage/>}/>
            <Route path="/wishlist" element={<Wishlist/>}/>
            <Route path="/login/forgot/password" element={<ForgotPass/>}/>
            <Route path="/mart" element={
              <>
                <MainpageAlog />
                <Trending />
                <Mobiles />
                <Sports />
                <Shirts />
                <Footer />
              </>
            } />
            <Route path="/" element={
              <>
                <MainPage />
                <Trending />
                <Mobiles />
                <Sports />
                <Shirts />
                <Footer />
              </>
            } />
            <Route path="/*" element={<ErrorPage />} />
          </Routes>
        </Router>
      </div>
    )
  }
  else {
    return (
      <Router>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/login/forgot/password" element={<ForgotPass/>}/>
          <Route path="/" element={
            <>
              <MainPage />
              <Trending />
              <Mobiles />
              <Sports />
              <Shirts />
              <Footer />
            </>
          } />
          <Route path="/*" element={<ErrorPage />} />
        </Routes>
      </Router>
    )
  }
}
export default App;
