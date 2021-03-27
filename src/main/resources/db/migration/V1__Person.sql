create extension if not exists "uuid-ossp";

create table public.person (
    id uuid not null default uuid_generate_v4(),
    "name" text not null
);