import makeApp from "./App/makeApp";
import populateDB from "./Postgresql/populate_db";
import dotenv from "dotenv";
import Database from "./Postgresql/database";

// flag for loading the env config file
if (process.env.NODE_ENV === "production") {
    dotenv.config({ path: ".env.prod" });
} else {
    dotenv.config({ path: ".env.dev" });
}

// flag for initalizing and populating the db
if (process.env.DB_STATUS === "init") {
    console.log("Init DB");
    populateDB();
}

const PORT = process.env.PORT || 3000;

makeApp(new Database()).listen(PORT, () =>
    console.log(`Server is live at localhost:${PORT}`)
);
