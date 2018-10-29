# Spring Cloud Config Vault Sample

## Step 1

Install Vault following the instructions [here](https://learn.hashicorp.com/vault/getting-started/install).

## Step 2

Start Vault in dev mode
```
$ vault server -dev
```

Make sure you note the root token of your Vault server you will need this later on.

## Step 3

Put some data in your Vault

```
$ vault kv put secret/application foo=bar baz=bam
$ vault kv put secret/myapp foo=myappsbar
```

## Step 4

Start the `vault-config-server` app.

Make an HTTP request to the config server to see if it can access Vault.

```
$ curl -X "GET" "http://localhost:8888/myapp/default" -H "X-Config-Token: YourRootToken"
```

Be sure to replace `YourRootToken` in the above command with your own Vault root token.
You should see the following

```
HTTP/1.1 200
Content-Type: application/json;charset=UTF-8
Date: Mon, 29 Oct 2018 18:53:20 GMT
Transfer-Encoding: chunked

{
    "label": null,
    "name": "myapp",
    "profiles": [
        "default"
    ],
    "propertySources": [
        {
            "name": "vault:myapp",
            "source": {
                "foo": "myappsbar"
            }
        },
        {
            "name": "vault:application",
            "source": {
                "baz": "bam",
                "foo": "bar"
            }
        }
    ],
    "state": null,
    "version": null
}
```

## Step 5

Open `bootstrap.yml` in `vault-config-client` and set your Vault root token in `spring.cloud.config.token`.

Start `vault-config-client`.  In the logs you should see the following in your logs

```
2018-10-29 15:10:10.605  INFO 44374 --- [           main] o.s.c.v.VaultConfigClientApplication     : Foo: myappsbar
2018-10-29 15:10:10.605  INFO 44374 --- [           main] o.s.c.v.VaultConfigClientApplication     : Bar: bam
```

