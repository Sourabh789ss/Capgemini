function add(a, b) {
    return a + b;
}

console.log(add(2, 2));


function userFriends(username:string, ...friends:string[]) {
    return username + "friends : " + friends.join(", ");
}
var friends = ["Beta", "Gama", "Delta", "Lamda"];
console.log(userFriends("Alpha", ...friends));

function printCapitalNames(alpha, beta , gama, delta, lamda) {
    console.log(alpha.toUpperCase());
    console.log(beta.toUpperCase());
    console.log( gama.toUpperCase());
    console.log(delta.toUpperCase());
    console.log( lamda.toUpperCase());
}

let allNames: [string, string, string, string, string] = [
    "Alpha",
    "Beta",
    "Gama",
    "Delta",
    "Lamda",
];

printCapitalNames(...allNames);