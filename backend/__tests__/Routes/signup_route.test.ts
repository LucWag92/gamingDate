import { describe, expect, it, jest } from "@jest/globals";
import request from "supertest";
import makeApp from "../../App/makeApp";
import IDatabase from "../../Postgresql/database.types";
import { ISignupParams } from "../../Routes/signup_route.types";

const createUserMock = jest.fn<Promise<boolean>, [ISignupParams]>();
const isEmailNotInDBMock = jest.fn<Promise<boolean>, [string]>();

const datatbaseMock: IDatabase = {
    createUser: createUserMock,
    isEmailNotInDB: isEmailNotInDBMock,
};
const app = makeApp(datatbaseMock);

describe("Testing SignUp: POST /api/v1/signup", () => {
    beforeEach(() => {
        createUserMock.mockReset();
        isEmailNotInDBMock.mockReset();
    });

    describe("Testing if parameters are passed correctly", () => {
        const bodyData: ISignupParams[] = [
            {
                email: "email1@test.de",
                password: "password1",
            },
            {
                email: "email2@test.de",
                password: "password2",
            },
        ];
        it("Parameter Check for createUserMock", async () => {
            for (const body1 of bodyData) {
                createUserMock.mockReset();
                createUserMock.mockReturnValue(Promise.resolve(true));
                isEmailNotInDBMock.mockReturnValue(Promise.resolve(true));
                const response1 = await request(app)
                    .post("/api/v1/signup")
                    .send(body1);
                expect(createUserMock.mock.calls[0][0].email).toBe(body1.email);
                expect(createUserMock.mock.calls[0][0].password).toBe(
                    body1.password
                );
            }
        });
        it("Parameter Check for isEmailNotInDBMock", async () => {
            for (const body2 of bodyData) {
                isEmailNotInDBMock.mockReset();
                const response2 = await request(app)
                    .post("/api/v1/signup")
                    .send(body2);
                expect(isEmailNotInDBMock.mock.calls[0][0]).toBe(body2.email);
            }
        });
    });
});
