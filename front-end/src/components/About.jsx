import React from "react";

const About = () => {
  return (
    <div className="flex gap-24 mt-14">
      <div className="w-1/2">
        <img src="./public/about.png" alt="" className="w-full" />
      </div>
      <div className="w-1/2">
        <h1 className="font-bold text-3xl">ABOUT US</h1>
        <br />
        <p className="font-normal text-3xl text-black/50 ">
          Welcome to ... a leading provider of comprehensive residential building management services. With years of
          experience in managing condominium complexes, our mission is to create safe, comfortable, and well-maintained
          living environments for all residents.
        </p>
        <br />
        <p className="font-normal text-3xl text-black/50  ">
          Our team of dedicated professionals is committed to delivering efficient, transparent, and responsive
          management solutions. We handle everything from maintenance services, security, and financial management to
          resident communications and community development.
        </p>
      </div>
    </div>
  );
};

export default About;
