import React from "react";

const Footer = () => {
  return (
    <div className="w-full bg-black text-white">
      <div className="flex  max-w-6xl mx-auto py-8 justify-between mb-14">
        <div className="w-1/3 flex flex-col gap-5">
          <div className="w-8 h-8 rounded-full border flex items-center justify-center text-black font-bold bg-white ">
            8
          </div>
          <p className="font-bold text-4xl">Want to recieve our awesome stories?</p>
          <div className="bg-white flex items-center justify-between border border-white">
            <input
              type="email"
              placeholder="Enter your email"
              className="bg-transparent ml-2 outline-none text-black"
            />
            <div className="bg-black py-1 px-2">Subcribe</div>
          </div>
        </div>
        <div className="flex gap-20 text-gray-500">
          <ul className="flex flex-col gap-5 ">
            <li className="text-white">Email</li>
            <li>infor@gmail.com</li>
          </ul>
          <ul className="flex flex-col gap-5">
            <li>About us</li>
            <li>How it work</li>
            <li>Pricing</li>
            <li>FAQs</li>
          </ul>
          <ul className="flex flex-col gap-5">
            <li>Lead Generation</li>
            <li>Customer Engagement</li>
            <li>Customer Support</li>
            <li>Help Center Articles</li>
            <li>Outgoing Messages</li>
          </ul>
        </div>
      </div>
      <div className="flex  max-w-6xl mx-auto py-4 justify-between">
        <div>© The 18 Design, All rights reserved.</div>
        <div>
          <div className="flex gap-10">
            <i className="fa-brands fa-facebook-f" />
            <i className="fa-brands fa-twitter" />
            <i className="fa-solid fa-g" />
            <i className="fa-brands fa-linkedin-in" />
            <i className="fa-brands fa-youtube" />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Footer;
