import multiprocessing as mp
import requests
import random
import datetime

api_url = "https://ajax-gateway-3xup8o1g.wl.gateway.dev/sensor?key=AIzaSyBusGUU9sFFhfMOZAilHUQDwQtTDGl-22I"


def post(x):
    while 1:
        name = 'light sensor'
        value = random.random() * 100
        coordinates = '35.90888590988924, 139.65510220113202'
        time_created = str(datetime.datetime.now())
        sensordata = {"name": name, "value": value, "coordinates": coordinates, "time_created": time_created}
        requests.post(api_url, json=sensordata)


def main():
    pool = mp.Pool(mp.cpu_count())
    pool.map(post, range(1))


if __name__ == "__main__":
    main()
