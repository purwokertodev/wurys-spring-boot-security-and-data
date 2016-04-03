CREATE TABLE user_blog_role
(
  id uuid NOT NULL DEFAULT uuid_generate_v1(),
  role_name character varying NOT NULL,
  user_blog_id uuid NOT NULL,
  created_at timestamp with time zone NOT NULL DEFAULT timezone('utc'::text, now()),
  created_by_id uuid NOT NULL,
  updated_at timestamp with time zone NOT NULL DEFAULT timezone('utc'::text, now()),
  updated_by_id uuid NOT NULL,
  deleted_at timestamp with time zone,
  deleted_by_id uuid,
  CONSTRAINT pk_user_blog_role PRIMARY KEY (id),
    CONSTRAINT fk_user_blog_id FOREIGN KEY (user_blog_id)
        REFERENCES user_blog (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_blog
  OWNER TO hcm;