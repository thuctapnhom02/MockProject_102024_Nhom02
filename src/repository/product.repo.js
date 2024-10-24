const {
  product,
  electronic,
  clothing,
  furniture,
} = require("../models/product.model.js");
const { Types } = require("mongoose");

const findAllDraftsForShop = async ({ query, limit, skip }) => {
  return await queryProduct({ query, limit, skip });
};

const findAllPublishedForShop = async ({ query, limit, skip }) => {
  return await queryProduct({ query, limit, skip });
};

const searchProductByUser = async ({ keySearch }) => {
  const regexSearch = new RegExp(keySearch);
  // full text search
  const result = await product
    .find(
      {
        isPublished: true,
        $text: {
          $search: regexSearch,
        },
      },
      {
        score: {
          $meta: "textScore",
        },
      }
    )
    .sort({
      score: {
        $meta: "textScore",
      },
    })
    .lean();

  return result;
};

const publishProductByShop = async ({ product_shop, product_id }) => {
  const foundShop = await product.findOne({
    product_shop: new Types.ObjectId(product_shop),
    _id: new Types.ObjectId(product_id),
  });
  if (!foundShop) return null;
  foundShop.isDraft = false;
  foundShop.isPublished = true;
  const { modifiedCount } = await foundShop.updateOne(foundShop); // 0 1
  return modifiedCount;
};

const unPublishProductByShop = async ({ product_shop, product_id }) => {
  const foundShop = await product.findOne({
    product_shop: new Types.ObjectId(product_shop),
    _id: new Types.ObjectId(product_id),
  });
  if (!foundShop) return null;
  foundShop.isDraft = true;
  foundShop.isPublished = false;
  const { modifiedCount } = await foundShop.updateOne(foundShop); // 0 1
  return modifiedCount;
};

const queryProduct = async ({ query, limit, skip }) => {
  return await product
    .find(query)
    // dung de lay cac thong tin tu bang khac lien quan den doi tuong hien tai
    .populate("product_shop", "name email -_id")
    // thu tu giam dan
    .sort({ updateAt: -1 })
    // bo qua 1 so documents, hỗ trợ phân trang.
    .skip(skip)
    .limit(limit)
    .lean()
    .exec(); // exec => dai dien cho cum tu de biet ta su dung async await trong mongoose => tra ve Promise
};

module.exports = {
  findAllDraftsForShop,
  publishProductByShop,
  findAllPublishedForShop,
  unPublishProductByShop,
  searchProductByUser,
};
