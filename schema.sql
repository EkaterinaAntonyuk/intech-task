CREATE TABLE public.SUBSCRIPTION
(
    id          bigint PRIMARY KEY,
    msisdn      bigint    NOT NULL,
    "timestamp" timestamp NOT NULL
);

CREATE TABLE public.purchase
(
    id          bigint PRIMARY KEY,
    msisdn      bigint    NOT NULL,
    "timestamp" timestamp NOT NULL
);