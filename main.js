const mainnetContract = "0xd24C6E9d3A57fa275344CFFfF86294035B27973d";

let minter = ""; 

const mainnetAbi = [
  { inputs: [], stateMutability: "nonpayable", type: "constructor" },
  {
    anonymous: false,
    inputs: [
      {
        indexed: true,
        internalType: "address",
        name: "owner",
        type: "address",
      },
      {
        indexed: true,
        internalType: "address",
        name: "approved",
        type: "address",
      },
      {
        indexed: true,
        internalType: "uint256",
        name: "tokenId",
        type: "uint256",
      },
    ],
    name: "Approval",
    type: "event",
  },
  {
    anonymous: false,
    inputs: [
      {
        indexed: true,
        internalType: "address",
        name: "owner",
        type: "address",
      },
      {
        indexed: true,
        internalType: "address",
        name: "operator",
        type: "address",
      },
      { indexed: false, internalType: "bool", name: "approved", type: "bool" },
    ],
    name: "ApprovalForAll",
    type: "event",
  },
  {
    anonymous: false,
    inputs: [
      {
        indexed: true,
        internalType: "address",
        name: "previousOwner",
        type: "address",
      },
      {
        indexed: true,
        internalType: "address",
        name: "newOwner",
        type: "address",
      },
    ],
    name: "OwnershipTransferred",
    type: "event",
  },
  {
    anonymous: false,
    inputs: [
      { indexed: true, internalType: "address", name: "from", type: "address" },
      { indexed: true, internalType: "address", name: "to", type: "address" },
      {
        indexed: true,
        internalType: "uint256",
        name: "tokenId",
        type: "uint256",
      },
    ],
    name: "Transfer",
    type: "event",
  },
  {
    inputs: [
      { internalType: "address", name: "who", type: "address" },
      { internalType: "uint256", name: "value", type: "uint256" },
    ],
    name: "mint",
    outputs: [],
    stateMutability: "payable",
    type: "function",
  },
  {
    inputs: [{ internalType: "string", name: "baseURI", type: "string" }],
    name: "setURI",
    outputs: [],
    stateMutability: "nonpayable",
    type: "function",
  },
  {
    inputs: [{ internalType: "string", name: "Name", type: "string" }],
    name: "setName",
    outputs: [],
    stateMutability: "nonpayable",
    type: "function",
  },
];

const cost = "60000000000000000";

var Web3;
var window;

async function getAccounts() {
  try {
    let acc = await window.ethereum.request({
      method: "eth_requestAccounts",
    });
    minter = acc[0]; // set minter global variable for mint function
    return acc;
  } catch (e) {
    return [];
  }
}

async function connectMetamask() {
  if (window.ethereum) {
    try {
      const result = await this.getAccounts();
      if (Array.isArray(result) && result.length > 0) {
        let acc = result[0];
        return acc;
      } else {
        return false;
      }
    } catch (err) {
      return false;
    }
  } else {
    return false;
  }
}

async function mint2() {
  console.log(minter);
  let totalToMint = document.getElementById("to_mint").value;
  var web3 = new Web3(Web3.givenProvider);
  window.contract = await new web3.eth.Contract(mainnetAbi, mainnetContract);
  const transactionParameters = {
    to: mainnetContract,
    from: (await this.getAccounts())[0],
    value: bigInt(cost).multiply(bigInt(totalToMint.toString())).toString(16),
    data: window.contract.methods.mint(minter, totalToMint).encodeABI(),
  };
  try {
    await window.ethereum.request({
      method: "eth_sendTransaction",
      params: [transactionParameters],
    });
  } catch (error) {
    console.log(error);
  }
}
