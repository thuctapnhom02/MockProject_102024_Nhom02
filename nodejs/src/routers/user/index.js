const express = require("express");
const productController = require("../../controllers/product.controller");
const asyncHandler = require("../../helper/asyncHandler");
const { authenticationV2 } = require("../../auth/authUtils");

const router = express.Router();
router.post(
  "/search/:keySearch",
  asyncHandler(productController.getListSearchProduct)
);
// authen v2
router.use(authenticationV2);
//
router.post("", asyncHandler(productController.createProduct));
router.post(
  "/publish/:id",
  asyncHandler(productController.publishProductByShop)
);

router.post(
  "/unpublish/:id",
  asyncHandler(productController.unPublishProductByShop)
);

// query
/**
 * @desc get all Drafts for shop
 * @param {Number} limit
 * @param {Number} skip
 * @return {JSON}
 */
router.get("/drafts/all", asyncHandler(productController.getAllDraftsForShop));

router.get(
  "/published/all",
  asyncHandler(productController.getAllPublishedForShop)
);

module.exports = router;
