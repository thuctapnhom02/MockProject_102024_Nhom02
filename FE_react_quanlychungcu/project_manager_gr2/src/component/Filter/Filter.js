import "./style.scss";

const Filter = ({ label, options, onFilter, selectedValue, style }) => {
  return (
    <div className="filter-container">
      <label className="filter-label">{label}</label>
      <select
        style={style}
        className="filter-select"
        value={selectedValue}
        onChange={(e) => {
          const selected = e.target.value;
          onFilter(selected);
        }}
      >
        {options.map((option) => (
          <option key={option} value={option}>
            {option}
          </option>
        ))}
      </select>
    </div>
  );
};

export default Filter;
