require("dotenv").config();
const express = require("express");
const morgan = require("morgan");
const { default: helmet } = require("helmet");
const compression = require("compression");
const { checkOverLoad } = require("./helper/check.connect.js");

const app = express();

// init middleware
// morgan -> in ra cac log
app.use(morgan("dev"));
// helmet -> che dau ca thong tin header
app.use(helmet());
// compression -> giam bang thong
app.use(compression());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
// init db
require("./databases/init.mongodb.js");
//checkOverLoad();
// init routes
app.use("/", require("./routers"));
// handling error (duong dan loi)
app.use((req, res, next) => {
  const error = new Error("Not Found");
  error.status = 404;
  next(error);
});

// ham xu ly error
app.use((error, req, res, next) => {
  const statusCode = error.status || 500;
  return res.status(statusCode).json({
    status: "error",
    code: statusCode,
    stack: error.stack, // development error
    message: error.message || "Internal Server Error",
  });
});

module.exports = app;
