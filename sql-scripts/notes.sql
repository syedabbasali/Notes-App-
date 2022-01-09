DROP SEQUENCE IF EXISTS public.notes_tbl_seq;

CREATE SEQUENCE IF NOT EXISTS public.notes_tbl_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9999999
    CACHE 1;

ALTER SEQUENCE public.notes_tbl_seq
    OWNER TO postgres;


DROP TABLE IF EXISTS public.notes_tbl;

CREATE TABLE IF NOT EXISTS public.notes_tbl
(
    id bigint NOT NULL,
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    author_name character varying(100) COLLATE pg_catalog."default",
    body text COLLATE pg_catalog."default" NOT NULL,
    attachment bytea,
	attachment_name character varying(100) COLLATE pg_catalog."default",
	attachment_type character varying(100) COLLATE pg_catalog."default",
    created_date timestamp with time zone NOT NULL,
    modified_date timestamp with time zone,
    CONSTRAINT notes_tbl_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.notes_tbl
    OWNER to postgres;