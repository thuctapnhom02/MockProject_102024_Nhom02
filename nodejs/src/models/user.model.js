const { model, Schema } = require("mongoose");
const slugify = require("slugify");

const DOCUMENT_NAME = "Product";
const COLLECTION_NAME = "Products";

const productSchema = new Schema(
  {
    product_name: {
      // quan jean cao cap
      type: String,
      require: true,
    },
    product_thumb: {
      type: String,
      require: true,
    },
    product_description: String,
    product_slug: String, // quan-jean-cap-cap
    product_price: {
      type: Number,
      require: true,
    },
    produc_quantity: {
      type: Number,
      require: true,
    },
    product_type: {
      type: String,
      require: true,
      enum: ["Electronic", "Clothing", "Furniture"],
    },
    product_shop: {
      type: Schema.Types.ObjectId,
      ref: "Shop",
    },
    product_attributes: {
      type: Schema.Types.Mixed,
      required: true,
    },
    //more
    product_ratingsAverage: {
      type: Number,
      default: 4.5,
      min: [1, "Rating mush be higher than 1.0"],
      max: [5, "Rating mush be lower than 5.0"],
      // 4,345666 = 4.3
      set: (value) => Math.round(value * 10) / 10,
    },
    product_variations: {
      type: Array,
      default: [],
    },
    isDraft: {
      type: Boolean,
      default: true,
      index: true, // danh index, vi hay su dung nhieu nhat
      select: false, // findOne, find se khong lay gia tri nay
    },
    isPublished: {
      type: Boolean,
      default: false, //
      index: true, // danh index, vi hay su dung nhieu nhat
      select: false, // findOne, find se khong lay gia tri nay
    },
  },
  {
    collection: COLLECTION_NAME,
    timestamps: true,
  }
);

// create index for search
productSchema.index({
  product_name: "text",
  product_description: "text",
});
// document middleware runs before .save() and create()...
productSchema.pre("save", function (next) {
  this.product_slug = slugify(this.product_name, { lower: true });
  next();
});

// define the product type = clothing
const clothingSchema = new Schema(
  {
    brand: {
      type: String,
      required: true,
    },
    size: String,
    meterial: String,
    product_shop: {
      type: Schema.Types.ObjectId,
      ref: "Shop",
    },
  },
  {
    collection: "Clothes",
    timestamps: true,
  }
);

// define the product type = electronic
const electronicSchema = new Schema(
  {
    manufacturer: {
      type: String,
      required: true,
    },
    model: String,
    color: String,
    product_shop: {
      type: Schema.Types.ObjectId,
      ref: "Shop",
    },
  },
  {
    collection: "Electronics",
    timestamps: true,
  }
);

const furnitureSchema = new Schema(
  {
    brand: {
      type: String,
      required: true,
    },
    size: String,
    material: String,
    product_shop: {
      type: Schema.Types.ObjectId,
      ref: "Shop",
    },
  },
  {
    collection: "Furnitures",
    timestamps: true,
  }
);

module.exports = {
  product: model(DOCUMENT_NAME, productSchema),
  electronic: model("Electronic", electronicSchema),
  clothing: model("Clothing", clothingSchema),
  furniture: model("Furniture", furnitureSchema),
};
