import React from "react";
import Navbar from "../components/Navbar";
import Banner from "../components/Banner";
import About from "../components/About";
import Services from "../components/Services";
import Footer from "../components/Footer";

const HomePage = () => {
  return (
    <>
      <Banner />
      <About />
      <Services />
    </>
  );
};

export default HomePage;
