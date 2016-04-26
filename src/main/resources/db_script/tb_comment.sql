
CREATE TABLE comment
(
  id uuid NOT NULL DEFAULT uuid_generate_v1(),
  post_id uuid NOT NULL,
  commentator_name character varying  NOT NULL,
  comment_content character varying NOT NULL,
  created_at timestamp with time zone NOT NULL DEFAULT timezone('utc'::text, now()),
  created_by_id uuid NOT NULL,
  updated_at timestamp with time zone NOT NULL DEFAULT timezone('utc'::text, now()),
  updated_by_id uuid NOT NULL,
  deleted_at timestamp with time zone,
  deleted_by_id uuid,
  CONSTRAINT pk_comment PRIMARY KEY (id),
  CONSTRAINT fk_post_id FOREIGN KEY (post_id)
      REFERENCES post (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE comment
  OWNER TO hcm;
