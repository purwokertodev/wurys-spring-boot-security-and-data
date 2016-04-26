CREATE TABLE user_blog
(
  id uuid NOT NULL DEFAULT uuid_generate_v1(),
  name character varying NOT NULL,
  email character varying NOT NULL,
  website character varying NOT NULL,
  password character varying NOT NULL,
  picture_location character varying NOT NULL,
  created_at timestamp with time zone NOT NULL DEFAULT timezone('utc'::text, now()),
  created_by_id uuid NOT NULL,
  updated_at timestamp with time zone NOT NULL DEFAULT timezone('utc'::text, now()),
  updated_by_id uuid NOT NULL,
  deleted_at timestamp with time zone,
  deleted_by_id uuid,
 CONSTRAINT pk_user_blog PRIMARY KEY (id)


)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_blog
  OWNER TO hcm;