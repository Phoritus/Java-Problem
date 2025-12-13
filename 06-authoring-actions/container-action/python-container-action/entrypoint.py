import os, datetime as dt

name = os.getenv("INPUT_WHO-TO-GREET", "World")

greeting = f"Hello, {name}! Time is {dt.datetime.now(dt.timezone.utc):%H:%M:%S} UTC."
print(greeting)

print(f"::set-output name=greeting::{greeting}")

with open(os.getenv("GITHUB_OUTPUT"), "a") as f:
    f.write(f"greeting={greeting}\n")