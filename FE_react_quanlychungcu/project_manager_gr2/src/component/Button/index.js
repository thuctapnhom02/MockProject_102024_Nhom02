import { Link } from "react-router-dom";

import "./style.scss";

function Button({
  to,
  href,
  primary = false,
  outline = false,
  text = false,
  rounded = false,
  disabled = false,
  small = false,
  large = false,
  children,
  className,
  leftIcon,
  rightIcon,
  onClick,
  ...passProps
}) {
  let Comp = "button";
  const props = {
    onClick,
    ...passProps,
  };

  // Remove event listener when btn is disabled
  if (disabled) {
    Object.keys(props).forEach((key) => {
      if (key.startsWith("on") && typeof props[key] === "function") {
        delete props[key];
      }
    });
  }

  if (to) {
    props.to = to;
    Comp = Link;
  } else if (href) {
    props.href = href;
    Comp = "a";
  }

  // Tạo className mà không cần cx
  const classes = [
    "button_wrapper",
    className,
    primary ? "primary" : "",
    outline ? "outline" : "",
    text ? "text" : "",
    disabled ? "disabled" : "",
    rounded ? "rounded" : "",
    small ? "small" : "",
    large ? "large" : "",
  ]
    .filter(Boolean) // Lọc các giá trị không hợp lệ
    .join(" "); // Nối các className lại thành một chuỗi

  return (
    <Comp className={classes} {...props}>
      {leftIcon && <span className="icon">{leftIcon}</span>}
      <span className="title">{children}</span>
      {rightIcon && <span className="icon">{rightIcon}</span>}
    </Comp>
  );
}

export default Button;
