const shopModel = require("../models/shop.model.");
const bcrypt = require("bcrypt");
const crypto = require("node:crypto");
const KeyTokenService = require("./keyToken.service");
const { createTokenPair } = require("../auth/authUtils");
const { getInfoData } = require("../utils");
const {
  BadRequestError,
  AuthFailureError,
  ForBiddenError,
} = require("../core/error.response");
const { findByEmail } = require("./shop.service");
const {
  Types: { ObjectId },
} = require("mongoose");

const roleShop = {
  SHOP: "SHOP",
  WRITER: "WRITER",
  EDITOR: "EDITOR",
  ADMIN: "ADMIN",
};

class AccessService {
  // check this token used
  static handlerRefreshTokenV2 = async ({ keyStore, user, refreshToken }) => {
    const { userId, email } = user;
    if (keyStore.refreshTokensUsed.includes(refreshToken)) {
      await KeyTokenService.deleteKeyById(userId);
      throw new ForBiddenError("Something went wrong, please relogging");
    }

    if (keyStore.refreshToken !== refreshToken) {
      throw new AuthFailureError("Shop not registered");
    }

    const foundShop = await findByEmail({ email });
    if (!foundShop) {
      throw new AuthFailureError("Shop not registered");
    }

    // creat 1 cap moi
    const tokens = await createTokenPair(
      { userId, email },
      keyStore.publicKey,
      keyStore.privateKey
    );

    await keyStore.updateOne({
      $set: {
        refreshToken: tokens.refreshToken,
      },
      $addToSet: {
        refreshTokensUsed: refreshToken, // Được thêm vào nếu chưa tồn tại
      },
    });
    // update token
    // await holderToken.updateOne({
    //   $set: {
    //     refreshToken: tokens.refreshToken,
    //   },
    //   $addToSet: {
    //     refreshTokensUsed: refreshToken, // da duoc su dung de lay token moi
    //   },
    // });
    return {
      user,
      tokens,
    };
  };

  // v1
  // static handlerRefreshToken = async (refreshToken) => {
  //   // check xem token da duoc su dung
  //   const foundToken = await KeyTokenService.findByRefreshTokenUsed(
  //     refreshToken
  //   );
  //   if (foundToken) {
  //     // decode xem ai dang truy cap

  //     const { userId, email } = await verifyJWT(
  //       refreshToken,
  //       foundToken.privateKey
  //     );
  //     console.log({ userId, email });
  //     // cach don gian: xoa tat ca tolen trong keystore
  //     await KeyTokenService.deleteKeyById(userId);
  //     throw new ForBiddenError("Something went wrong, please relogging");
  //   }
  //   // chua su dung
  //   const holderToken = await KeyTokenService.findByRefreshToken(refreshToken);
  //   if (!holderToken) throw new AuthFailureError("Shop not registered");
  //   // verify token

  //   const { userId, email } = await verifyJWT(
  //     refreshToken,
  //     holderToken.privateKey
  //   );

  //   console.log(`[2]--`, { userId, email });
  //   // check userId
  //   const foundShop = await findByEmail({ email });
  //   if (!foundShop) {
  //     throw new AuthFailureError("Shop not registered");
  //   }
  //   // creat 1 cap moi
  //   const tokens = await createTokenPair(
  //     { userId, email },
  //     holderToken.publicKey,
  //     holderToken.privateKey
  //   );

  //   await holderToken.updateOne({
  //     $set: {
  //       refreshToken: tokens.refreshToken,
  //     },
  //     $addToSet: {
  //       refreshTokensUsed: refreshToken, // Được thêm vào nếu chưa tồn tại
  //     },
  //   });
  //   // update token
  //   // await holderToken.updateOne({
  //   //   $set: {
  //   //     refreshToken: tokens.refreshToken,
  //   //   },
  //   //   $addToSet: {
  //   //     refreshTokensUsed: refreshToken, // da duoc su dung de lay token moi
  //   //   },
  //   // });
  //   return {
  //     user: {
  //       userId,
  //       email,
  //     },
  //     tokens,
  //   };
  // };

  static logout = async (keyStore) => {
    const delKey = await KeyTokenService.removeKeyById(keyStore._id);
    console.log({ delKey });
    return delKey;
  };

  /*
  1. check email in dbs
  2. match password
  3. create accessToken and refreshToken and save
  4. generate tokens
  5. get data return login
  */
  static login = async ({ email, password, refreshToken = null }) => {
    // 1
    const foundShop = await findByEmail({ email });
    if (!foundShop) {
      throw new BadRequestError("Error: Shop not registered!");
    }
    // 2
    const match = bcrypt.compare(password, foundShop.password);
    if (!match) {
      throw new AuthFailureError("Error: Authentication Error!");
    }

    // 3
    // created privateKey and publicKey
    const privateKey = crypto.randomBytes(64).toString("hex");
    const publicKey = crypto.randomBytes(64).toString("hex");

    const { _id: userId } = foundShop;
    // 4
    const tokens = await createTokenPair(
      { userId, email },
      publicKey,
      privateKey
    );

    await KeyTokenService.createKeyToken({
      refreshToken: tokens.refreshToken,
      publicKey,
      privateKey,
      userId,
    });

    return {
      shop: getInfoData({
        fields: ["_id", "name", "email"],
        object: foundShop,
      }),
      tokens,
    };
  };

  static signUp = async ({ name, email, password }) => {
    // try {
    // st1: check email exists??
    // lean tra ve object js thuan, giup query nhanh hon, giam tai size cua object nho hon gan 30 lan
    // neu ko co lean se return ve object cua mongoC (co thong tin ko can thiet nhu thong tin ket noi,..)
    const holderShop = await shopModel.findOne({ email }).lean();
    if (holderShop) {
      throw new BadRequestError("Error: Shop already registered!!");
    }
    // hash password 10: bam 10 lan, cang nhieu cang anh huong cpu
    const passwordHash = await bcrypt.hash(password, 10);
    const newShop = await shopModel.create({
      name,
      email,
      password: passwordHash,
      roles: [roleShop.SHOP],
    });

    if (newShop) {
      // cach1: bao mat cao, dung thuat toan bat doi xung
      // created privateKey (ko luu -> sign token) and publicKey (luu -> verify token)
      // dung thuat toan bat doi xung rsa
      // const { privateKey, publicKey } = crypto.generateKeyPairSync("rsa", {
      //   modulusLength: 4096,
      //   publicKeyEncoding: {
      //     type: "pkcs1", // Public key Cryptographic Standards 1
      //     format: "pem", //
      //   },
      //   privateKeyEncoding: {
      //     type: "pkcs1", // Public key Cryptographic Standards 1
      //     format: "pem", //
      //   },
      // });

      // cach 2:don gian hon
      const privateKey = crypto.randomBytes(64).toString("hex");
      const publicKey = crypto.randomBytes(64).toString("hex");

      console.log({ privateKey, publicKey }); // save collection keystore
      const keyStore = await KeyTokenService.createKeyToken({
        userId: newShop._id,
        publicKey,
        privateKey,
      });
      if (!keyStore) {
        throw new BadRequestError("Error: publicKeyString error!!");
        // return {
        //   code: "xxxx",
        //   message: "publicKeyString error",
        // };
      }
      // console.log(`publicKeyString::`, publicKeyString);
      // const publicKeyObject = crypto.createPublicKey(publicKeyString);
      // console.log(`publicKeyObject::`, publicKeyObject);
      // create token pair
      const tokens = await createTokenPair(
        { userId: newShop._id, email },
        publicKey,
        privateKey
      );
      console.log(`created token success:: `, tokens);

      return {
        code: 201,
        metadata: {
          shop: getInfoData({
            fields: ["_id", "name", "email"],
            object: newShop,
          }),
          tokens,
        },
      };
    }
    return {
      code: 200,
      metadata: null,
    };
    // } catch (error) {
    //   return {
    //     code: "xxx",
    //     message: error.message,
    //     status: "error",
    //   };
    // }
  };
}

module.exports = AccessService;
