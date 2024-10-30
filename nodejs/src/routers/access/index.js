const express = require("express");
const accessController = require("../../controllers/access.controller");
const asyncHandler = require("../../helper/asyncHandler");
const { authenticationV2 } = require("../../auth/authUtils");

const router = express.Router();

// signUp
router.post("/shop/signup", asyncHandler(accessController.signUp));
//login
router.post("/shop/login", asyncHandler(accessController.login));

// authen v2
router.use(authenticationV2);
//
router.post("/shop/logout", asyncHandler(accessController.logout));
router.post(
  "/shop/handlerRefreshToken",
  asyncHandler(accessController.handlerRefreshToken)
);
module.exports = router;
