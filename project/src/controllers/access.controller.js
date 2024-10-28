const { CREATED, SuccessResponse } = require("../core/success.response");
const AccessService = require("../services/access.service");

class AccessController {
  // v1
  // handlerRefreshToken = async (req, res, next) => {
  //   new SuccessResponse({
  //     message: "Get tokens successfully",
  //     metadata: await AccessService.handlerRefreshToken(req.body.refreshToken),
  //   }).send(res);
  // };

  // v2: no need AT
  handlerRefreshToken = async (req, res, next) => {
    new SuccessResponse({
      message: "Get tokens successfully",
      metadata: await AccessService.handlerRefreshTokenV2({
        refreshToken: req.refreshToken,
        user: req.user,
        keyStore: req.keyStore,
      }),
    }).send(res);
  };

  logout = async (req, res, next) => {
    new SuccessResponse({
      message: "Logout successfully",
      metadata: await AccessService.logout(req.keyStore),
    }).send(res);
  };

  login = async (req, res, next) => {
    new SuccessResponse({
      metadata: await AccessService.login(req.body),
    }).send(res);
  };

  signUp = async (req, res, next) => {
    // try

    console.log(`[P]::signUp::`, req.body);
    //   200: OK
    //   201: CREATED
    // return res.status(200).json({
    //   message: "",
    //   metadata:
    // })
    new CREATED({
      message: "Registered OK!",
      metadata: await AccessService.signUp(req.body),
      options: {
        limit: 10,
      },
    }).send(res);
    // return res.status(200).json();
    // } catch (e) {
    //   next(e);
    // }
  };
}

module.exports = new AccessController();
