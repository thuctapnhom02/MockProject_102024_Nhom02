import React from "react";

const Navbar = () => {
  return (
    <>
      <nav className="bg-transparent absolute top-[60px] z-10 w-full">
        <ul className="flex gap-7 justify-end text-2xl p-[10px] font-bold">
          <li className="cursor-pointer py-2">Home</li>
          <li className="cursor-pointer py-2">Properties</li>
          <li className="cursor-pointer py-2">Owners</li>
          <li className="cursor-pointer py-2">Residents</li>
          <li className="cursor-pointer py-2">Blog</li>
          <li className="cursor-pointer py-2">About</li>
          <li className="cursor-pointer py-2">Contact</li>
          <li className="cursor-pointer py-2">Login</li>
        </ul>
      </nav>
    </>
  );
};

export default Navbar;
