
CREATE TABLE post
(
  id uuid NOT NULL DEFAULT uuid_generate_v1(),
  user_blog_id uuid NOT NULL,
  post_title character varying  NOT NULL,
  post_content character varying NOT NULL,
  created_at timestamp with time zone NOT NULL DEFAULT timezone('utc'::text, now()),
  created_by_id uuid NOT NULL,
  updated_at timestamp with time zone NOT NULL DEFAULT timezone('utc'::text, now()),
  updated_by_id uuid NOT NULL,
  deleted_at timestamp with time zone,
  deleted_by_id uuid,
  CONSTRAINT pk_post PRIMARY KEY (id),
  CONSTRAINT fk_user_blog_id FOREIGN KEY (user_blog_id)
      REFERENCES user_blog (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE post
  OWNER TO hcm;