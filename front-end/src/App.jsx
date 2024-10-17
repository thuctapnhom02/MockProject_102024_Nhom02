import React from "react";
import HomePage from "./Pages/HomePage";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";

const App = () => {
  return (
    <div className="relative max-w-[1326px] mx-auto">
      <Navbar />
      <HomePage />
      <Footer />
    </div>
  );
};

export default App;
