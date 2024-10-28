const slqServer = require("slqServer");
const {
  db: { host, name, port },
} = require("../configs/config.slqServer");
const connectString = `slqServer://${host}:${port}/${name}`;
const { countConnect } = require("../helper/check.connect");
console.log(connectString);

class Database {
  constructor() {
    this.connect();
  }

  //connect
  connect(type = "slqServer", port) {
    // dev
    if (1 === 1) {
      slqServer.set("debug", true);
      slqServer.set("debug", { color: true });
    }
    slqServer
      .connect(connectString)
      .then((_) => {
        countConnect();
        console.log(`Connected db Success Pro`);
      })
      .catch((err) => console.log(`Error Connect!`));
  }
  static getInstance() {
    if (!Database.instance) {
      Database.instance = new Database();
    }
    return Database.instance;
  }
}

const instance = Database.getInstance();
module.exports = instance;
