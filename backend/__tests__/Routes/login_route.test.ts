import { describe, expect, it } from "@jest/globals";
import request from "supertest";
import makeApp from "../../App/makeApp";

describe("Testing Login", () => {
    it("Both wrong parmaters", async () => {
        await request(makeApp)
            .post("/api/v1/login")
            .expect(400)
            .then((response) => {
                expect(response.text).toEqual(
                    "email and password must be provided"
                );
            });
    });
    it("One wrong parmaters", async () => {
        await request(makeApp)
            .post("/api/v1/login")
            .send({ password: "pw" })
            .expect(400)
            .then((response) => {
                expect(response.text).toEqual(
                    "email and password must be provided"
                );
            });
        await request(makeApp)
            .post("/api/v1/login")
            .send({ email: "email" })
            .expect(400)
            .then((response) => {
                expect(response.text).toEqual(
                    "email and password must be provided"
                );
            });
    });
    it("Valid parameters", async () => {
        await request(makeApp)
            .post("/api/v1/login")
            .send({ email: "user", password: "pw" })
            .expect(200)
            .then((response) => {
                expect(response.text).toEqual("LogIn");
            });
    });
});
