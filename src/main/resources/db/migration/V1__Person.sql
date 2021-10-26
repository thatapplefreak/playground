create table public.person (
    id uuid not null default random_uuid(),
    "name" text not null
);