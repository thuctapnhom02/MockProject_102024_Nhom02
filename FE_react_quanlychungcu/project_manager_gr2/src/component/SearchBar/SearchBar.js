import { FaSearch } from "react-icons/fa"; // Thêm icon kính lúp từ react-icons

import "./style.scss";
const SearchBar = ({ onSearch }) => {
  return (
    <div className="search-bar">
      <FaSearch className="search-icon" />
      <input
        type="text"
        placeholder="Search"
        onChange={(e) => onSearch(e.target.value)}
        className="search-input"
      />
    </div>
  );
};

export default SearchBar;
