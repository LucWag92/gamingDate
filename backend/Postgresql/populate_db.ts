import pg from "pg";
// docs: https://node-postgres.com/features/connecting
const populateDB = () => {
    const client = new pg.Client({
        user: process.env.DB_USER,
        host: "localhost",
        database: process.env.DB_NAME,
        password: process.env.DB_PW,
        port: 5432,
    });
    client.connect();

    // Squences
    client
        .query(
            `DROP SEQUENCE IF EXISTS public.accountdata_accountdataid_seq CASCADE;
      
            CREATE SEQUENCE public.accountdata_accountdataid_seq
            INCREMENT 1
            START 1
            MINVALUE 1
            MAXVALUE 9223372036854775807
            CACHE 1;`
        )
        .then((res) =>
            console.log(`Res_Seq accountdata_accountdataid_seq: ${res}`)
        )
        .catch((err) =>
            console.log(`Err_Seq accountdata_accountdataid_seq: ${err}`)
        );
    client
        .query(
            `DROP SEQUENCE IF EXISTS public.clan_clanid_seq CASCADE;

            CREATE SEQUENCE public.clan_clanid_seq
            INCREMENT 1
            START 1
            MINVALUE 1
            MAXVALUE 9223372036854775807
            CACHE 1;`
        )
        .then((res) => console.log(`Res_Seq clan_clanid_seq: ${res}`))
        .catch((err) => console.log(`Err_Seq clan_clanid_seq: ${err}`));
    client
        .query(
            `DROP SEQUENCE IF EXISTS public.game_gameid_seq CASCADE;

            CREATE SEQUENCE public.game_gameid_seq
            INCREMENT 1
            START 1
            MINVALUE 1
            MAXVALUE 9223372036854775807
            CACHE 1;`
        )
        .then((res) => console.log(`Res_Seq game_gameid_seq: ${res}`))
        .catch((err) => console.log(`Err_Seq game_gameid_seq: ${err}`));
    client
        .query(
            `DROP SEQUENCE IF EXISTS public.onlinestatus_onlinestatusid_seq CASCADE;

            CREATE SEQUENCE public.onlinestatus_onlinestatusid_seq
            INCREMENT 1
            START 1
            MINVALUE 1
            MAXVALUE 9223372036854775807
            CACHE 1;`
        )
        .then((res) =>
            console.log(`Res_Seq onlinestatus_onlinestatusid_seq: ${res}`)
        )
        .catch((err) =>
            console.log(`Err_Seq onlinestatus_onlinestatusid_seq: ${err}`)
        );
    client
        .query(
            `DROP SEQUENCE IF EXISTS public.profile_profileid_seq CASCADE;

            CREATE SEQUENCE public.profile_profileid_seq
            INCREMENT 1
            START 1
            MINVALUE 1
            MAXVALUE 9223372036854775807
            CACHE 1;`
        )
        .then((res) => console.log(`Res_Seq profile_profileid_seq: ${res}`))
        .catch((err) => console.log(`Err_Seq profile_profileid_seq: ${err}`));
    client
        .query(
            `DROP SEQUENCE IF EXISTS public.usertable_userid_seq CASCADE;

            CREATE SEQUENCE public.usertable_userid_seq
            INCREMENT 1
            START 1
            MINVALUE 1
            MAXVALUE 9223372036854775807
            CACHE 1;`
        )
        .then((res) => console.log(`Res_Seq usertable_userid_seq: ${res}`))
        .catch((err) => console.log(`Err_Seq usertable_userid_seq: ${err}`));

    // Tables
    client
        .query(
            `DROP TABLE IF EXISTS public.accountdata CASCADE;

            CREATE TABLE public.accountdata
            (
                accountdataid bigint NOT NULL DEFAULT nextval('accountdata_accountdataid_seq'::regclass),
                email character varying(255) COLLATE pg_catalog."default" NOT NULL,
                hashedpassword character varying(255) COLLATE pg_catalog."default" NOT NULL
            )`
        )
        .then((res) => console.log(`Res_Table accountdata: ${res}`))
        .catch((err) => console.log(`Err_Table accountdata: ${err}`));
    client
        .query(
            `DROP TABLE IF EXISTS public.clan CASCADE;

            CREATE TABLE public.clan
            (
                clanid bigint NOT NULL DEFAULT nextval('clan_clanid_seq'::regclass),
                clanname character varying(255) COLLATE pg_catalog."default",
                lastfavouritegame character varying(255) COLLATE pg_catalog."default"
            )`
        )
        .then((res) => console.log(`Res_Table clan: ${res}`))
        .catch((err) => console.log(`Err_Table clan: ${err}`));
    client
        .query(
            `DROP TABLE IF EXISTS public.friendprofiles CASCADE;

            CREATE TABLE public.friendprofiles
            (
                profileid bigint NOT NULL,
                friendprofilesid bigint NOT NULL
            )`
        )
        .then((res) => console.log(`Res_Table friendprofiles: ${res}`))
        .catch((err) => console.log(`Err_Table friendprofiles: ${err}`));
    client
        .query(
            `DROP TABLE IF EXISTS public.game CASCADE;

            CREATE TABLE public.game
            (
                gameid bigint NOT NULL DEFAULT nextval('game_gameid_seq'::regclass),
                end_time timestamp without time zone NOT NULL,
                gamelogourl character varying(255) COLLATE pg_catalog."default",
                gamename character varying(255) COLLATE pg_catalog."default",
                rating integer,
                starttime timestamp without time zone NOT NULL
            )`
        )
        .then((res) => console.log(`Res_Table game: ${res}`))
        .catch((err) => console.log(`Err_Table game: ${err}`));
    client
        .query(
            `DROP TABLE IF EXISTS public.gamerprofiles CASCADE;

            CREATE TABLE public.gamerprofiles
            (
                gameid bigint NOT NULL,
                profileid bigint NOT NULL
            )`
        )
        .then((res) => console.log(`Res_Table gamerprofiles: ${res}`))
        .catch((err) => console.log(`Err_Table gamerprofiles: ${err}`));
    client
        .query(
            `DROP TABLE IF EXISTS public.memberprofiles CASCADE;

            CREATE TABLE public.memberprofiles
            (
                profileid bigint NOT NULL,
                clanid bigint NOT NULL
            )`
        )
        .then((res) => console.log(`Res_Table memberprofiles: ${res}`))
        .catch((err) => console.log(`Err_Table memberprofiles: ${err}`));
    client
        .query(
            `DROP TABLE IF EXISTS public.onlinestatus CASCADE;

            CREATE TABLE public.onlinestatus
            (
                onlinestatusid bigint NOT NULL DEFAULT nextval('onlinestatus_onlinestatusid_seq'::regclass),
                status character varying(255) COLLATE pg_catalog."default"
            )`
        )
        .then((res) => console.log(`Res_Table onlinestatus: ${res}`))
        .catch((err) => console.log(`Err_Table onlinestatus: ${err}`));
    client
        .query(
            `DROP TABLE IF EXISTS public.profile CASCADE;

            CREATE TABLE public.profile
            (
                profileid bigint NOT NULL DEFAULT nextval('profile_profileid_seq'::regclass),
                profileimageurl character varying(255) COLLATE pg_catalog."default",
                profilename character varying(255) COLLATE pg_catalog."default",
                onlinestatusid bigint NOT NULL
            )`
        )
        .then((res) => console.log(`Res_Table profile: ${res}`))
        .catch((err) => console.log(`Err_Table profile: ${err}`));
    client
        .query(
            `DROP TABLE IF EXISTS public.usertable CASCADE;

            CREATE TABLE public.usertable
            (
                userid bigint NOT NULL DEFAULT nextval('usertable_userid_seq'::regclass),
                accountdataid bigint NOT NULL,
                profileid bigint NOT NULL
            )`
        )
        .then((res) => console.log(`Res_Table usertable: ${res}`))
        .catch((err) => console.log(`Err_Table usertable: ${err}`));

    //Constraints
    // unique + pks first
    client
        .query(
            `ALTER TABLE public.accountdata
              DROP CONSTRAINT IF EXISTS accountdata_accountdataid_pkey,
              DROP CONSTRAINT IF EXISTS accountdata_email_unique;

            ALTER TABLE public.accountdata
              ADD CONSTRAINT accountdata_accountdataid_pkey PRIMARY KEY (accountdataid),
              ADD CONSTRAINT accountdata_email_unique UNIQUE (email);`
        )
        .then((res) => console.log(`Res_Constraint_Unique accountdata: ${res}`))
        .catch((err) =>
            console.log(`Err_Constraint_Unique accountdata: ${err}`)
        );

    client
        .query(
            `ALTER TABLE public.clan
              DROP CONSTRAINT IF EXISTS clan_clanid_pkey,
              DROP CONSTRAINT IF EXISTS clan_clanname_unique;

            ALTER TABLE public.clan
              ADD CONSTRAINT clan_clanid_pkey PRIMARY KEY (clanid),
              ADD CONSTRAINT clan_clanname_unique UNIQUE (clanname);`
        )
        .then((res) => console.log(`Res_Constraint_Unique clan: ${res}`))
        .catch((err) => console.log(`Err_Constraint_Unique clan: ${err}`));

    client
        .query(
            `ALTER TABLE public.friendprofiles
                DROP CONSTRAINT IF EXISTS friendprofiles_friendprofilesid_profileid_unique;

              ALTER TABLE public.friendprofiles
                ADD CONSTRAINT friendprofiles_friendprofilesid_profileid_unique UNIQUE (friendprofilesid, profileid);`
        )
        .then((res) =>
            console.log(`Res_Constraint_Unique friendprofiles: ${res}`)
        )
        .catch((err) =>
            console.log(`Err_Constraint_Unique friendprofiles: ${err}`)
        );
    client
        .query(
            `ALTER TABLE public.game
              DROP CONSTRAINT IF EXISTS game_pkey,
              DROP CONSTRAINT IF EXISTS game_gamename_unique;

            ALTER TABLE public.game
              ADD CONSTRAINT game_pkey PRIMARY KEY (gameid),
              ADD CONSTRAINT game_gamename_unique UNIQUE (gamename);`
        )
        .then((res) => console.log(`Res_Constraint_Unique game: ${res}`))
        .catch((err) => console.log(`Err_Constraint_Unique game: ${err}`));
    client
        .query(
            `ALTER TABLE public.gamerprofiles
              DROP CONSTRAINT IF EXISTS gamerprofiles_gameid_profileid_unique;

            ALTER TABLE public.gamerprofiles
              ADD CONSTRAINT gamerprofiles_gameid_profileid_unique UNIQUE (gameid, profileid);`
        )
        .then((res) =>
            console.log(`Res_Constraint_Unique gamerprofiles: ${res}`)
        )
        .catch((err) =>
            console.log(`Err_Constraint_Unique gamerprofiles: ${err}`)
        );
    client
        .query(
            `ALTER TABLE public.memberprofiles
              DROP CONSTRAINT IF EXISTS memberprofiles_clanid_profileid_unique;

            ALTER TABLE public.memberprofiles
              ADD CONSTRAINT memberprofiles_clanid_profileid_unique UNIQUE (clanid, profileid);`
        )
        .then((res) =>
            console.log(`Res_Constraint_Unique memberprofiles: ${res}`)
        )
        .catch((err) =>
            console.log(`Err_Constraint_Unique memberprofiles: ${err}`)
        );
    client
        .query(
            `ALTER TABLE public.onlinestatus
              DROP CONSTRAINT IF EXISTS onlinestatus_onlinestatusid_pkey;

            ALTER TABLE public.onlinestatus
              ADD CONSTRAINT onlinestatus_onlinestatusid_pkey PRIMARY KEY (onlinestatusid);`
        )
        .then((res) =>
            console.log(`Res_Constraint_Unique onlinestatus: ${res}`)
        )
        .catch((err) =>
            console.log(`Err_Constraint_Unique onlinestatus: ${err}`)
        );
    client
        .query(
            `ALTER TABLE public.profile
              DROP CONSTRAINT IF EXISTS profile_profileid_pkey,
              DROP CONSTRAINT IF EXISTS profile_profilename_unique;

            ALTER TABLE public.profile
              ADD CONSTRAINT profile_profileid_pkey PRIMARY KEY (profileid),
              ADD CONSTRAINT profile_profilename_unique UNIQUE (profilename);`
        )
        .then((res) => console.log(`Res_Constraint_Unique profile: ${res}`))
        .catch((err) => console.log(`Err_Constraint_Unique profile: ${err}`));
    client
        .query(
            `ALTER TABLE public.usertable
              DROP CONSTRAINT IF EXISTS usertable_userid_pkey,

            ALTER TABLE public.usertable
              ADD CONSTRAINT usertable_userid_pkey PRIMARY KEY (userid);`
        )
        .then((res) => console.log(`Res_Constraint_Unique usertable: ${res}`))
        .catch((err) => console.log(`Err_Constraint_Unique usertable: ${err}`));
    // fk last
    client
        .query(
            `ALTER TABLE public.friendprofiles
              DROP CONSTRAINT IF EXISTS friendprofiles_profileid_fk,
              DROP CONSTRAINT IF EXISTS friendprofiles_friendprofilesid_fk;

            ALTER TABLE public.friendprofiles
              ADD CONSTRAINT friendprofiles_profileid_fk FOREIGN KEY (profileid)
                  REFERENCES public.profile (profileid) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION,
              ADD CONSTRAINT friendprofiles_friendprofilesid_fk FOREIGN KEY (friendprofilesid)
                  REFERENCES public.profile (profileid) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION;`
        )
        .then((res) => console.log(`Res_Constraint_fk friendprofiles: ${res}`))
        .catch((err) =>
            console.log(`Err_Constraint_fk friendprofiles: ${err}`)
        );

    client
        .query(
            `ALTER TABLE public.gamerprofiles
              DROP CONSTRAINT IF EXISTS gamerprofiles_profileid_fk,
              DROP CONSTRAINT IF EXISTS gameid_fk;

            ALTER TABLE public.gamerprofiles
              ADD CONSTRAINT gamerprofiles_profileid_fk FOREIGN KEY (profileid)
                  REFERENCES public.profile (profileid) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION,
              ADD CONSTRAINT gameid_fk FOREIGN KEY (gameid)
                  REFERENCES public.game (gameid) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION;`
        )
        .then((res) => console.log(`Res_Constraint_fk gamerprofiles: ${res}`))
        .catch((err) => console.log(`Err_Constraint_fk gamerprofiles: ${err}`));
    client
        .query(
            `ALTER TABLE public.memberprofiles
              DROP CONSTRAINT IF EXISTS memberprofiles_profileid_fk,
              DROP CONSTRAINT IF EXISTS memberprofiles_clanid_fk;

            ALTER TABLE public.memberprofiles
              ADD CONSTRAINT memberprofiles_profileid_fk FOREIGN KEY (profileid)
                  REFERENCES public.clan (clanid) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION,
              ADD CONSTRAINT memberprofiles_clanid_fk FOREIGN KEY (clanid)
                  REFERENCES public.profile (profileid) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION;`
        )
        .then((res) => console.log(`Res_Constraint_fk memberprofiles: ${res}`))
        .catch((err) =>
            console.log(`Err_Constraint_fk memberprofiles: ${err}`)
        );

    client
        .query(
            `ALTER TABLE public.profile
              DROP CONSTRAINT IF EXISTS profile_profilename_fk;

            ALTER TABLE public.profile
              ADD CONSTRAINT profile_profilename_fk FOREIGN KEY (onlinestatusid)
                  REFERENCES public.onlinestatus (onlinestatusid) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION;`
        )
        .then((res) => console.log(`Res_Constraint_fk profile: ${res}`))
        .catch((err) => console.log(`Err_Constraint_fk profile: ${err}`));
    client
        .query(
            `ALTER TABLE public.usertable
              DROP CONSTRAINT IF EXISTS usertable_accountdataid_fk,
              DROP CONSTRAINT IF EXISTS usertable_profileid_fk;

            ALTER TABLE public.usertable
              ADD CONSTRAINT usertable_accountdataid_fk FOREIGN KEY (accountdataid)
                  REFERENCES public.accountdata (accountdataid) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION,
              ADD CONSTRAINT usertable_profileid_fk FOREIGN KEY (profileid)
                  REFERENCES public.profile (profileid) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION;`
        )
        .then((res) => console.log(`Res_Constraint_fk usertable: ${res}`))
        .catch((err) => console.log(`Err_Constraint_fk usertable: ${err}`));
};

export default populateDB;
