---
title: t-learn API v0.0.1
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
highlight_theme: darkula
headingLevel: 2

---

<!-- Generator: Widdershins v4.0.1 -->

<h1 id="t-learn-api">t-learn API v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

Backend API сервиса t-learn

Base URLs:

* <a href="http://localhost:8080">http://localhost:8080</a>

# Authentication

- HTTP Authentication, scheme: bearer Opaque токен доступа, полученный на /api/v1/auth/verify

<h1 id="t-learn-api-auth">auth</h1>

Авторизация по OTP-коду, выдача и инвалидация opaque токена

## sendOtp

<a id="opIdsendOtp"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/auth/send \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json'

```

```http
POST http://localhost:8080/api/v1/auth/send HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "email": "user@example.com"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/api/v1/auth/send',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => 'application/json'
}

result = RestClient.post 'http://localhost:8080/api/v1/auth/send',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.post('http://localhost:8080/api/v1/auth/send', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => 'application/json',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/v1/auth/send', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/auth/send");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"application/json"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/auth/send", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/auth/send`

*Отправить OTP-код*

Отправляет одноразовый код на указанную почту.

> Body parameter

```json
{
  "email": "user@example.com"
}
```

<h3 id="sendotp-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[SendOtpRequest](#schemasendotprequest)|true|none|

> Example responses

> 200 Response

```json
{
  "requestId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "expiresIn": 300,
  "retryAfter": 60
}
```

> 400 Response

```json
{
  "code": "VALIDATION_ERROR",
  "message": "Некорректный формат email"
}
```

> 429 Response

```json
{
  "code": "SEND_OTP_RATE_LIMIT_EXCEEDED",
  "message": "Повторная отправка возможна через 45 секунд"
}
```

<h3 id="sendotp-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Код успешно отправлен.|[SendOtpResponse](#schemasendotpresponse)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Поле email отсутствует/пустое/невалидный формат|[Error](#schemaerror)|
|429|[Too Many Requests](https://tools.ietf.org/html/rfc6585#section-4)|Превышен рейтлимит отправок кода|[Error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## verifyOtp

<a id="opIdverifyOtp"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/auth/verify \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json'

```

```http
POST http://localhost:8080/api/v1/auth/verify HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "requestId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "code": "483920"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/api/v1/auth/verify',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => 'application/json'
}

result = RestClient.post 'http://localhost:8080/api/v1/auth/verify',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.post('http://localhost:8080/api/v1/auth/verify', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => 'application/json',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/v1/auth/verify', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/auth/verify");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"application/json"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/auth/verify", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/auth/verify`

*Проверить OTP код*

Проверяет код из письма и возвращает opaque токен доступа

> Body parameter

```json
{
  "requestId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "code": "483920"
}
```

<h3 id="verifyotp-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[VerifyRequest](#schemaverifyrequest)|true|none|

> Example responses

> 200 Response

```json
{
  "accessToken": "9f2c1b7a4d6e8f0a3b5c7d9e1f2a4b6c",
  "tokenType": "Bearer",
  "expiresIn": 2592000
}
```

> 400 Response

```json
{
  "code": "VALIDATION_ERROR",
  "message": "Некорректное значение поля"
}
```

> 401 Response

```json
{
  "code": "VERIFY_INVALID_OTP",
  "message": "Неверный или просроченный код подтверждения"
}
```

> 429 Response

```json
{
  "code": "VERIFY_RATE_LIMIT_EXCEEDED",
  "message": "Повторное подтверждение возможно через 45 секунд"
}
```

<h3 id="verifyotp-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OTP код подтвержден|[VerifyResponse](#schemaverifyresponse)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Ошибка валидации запроса (невалидное значение поля, отсутствует обязательное поле, нарушен формат данных)|[Error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Неверный или просроченный код|[Error](#schemaerror)|
|429|[Too Many Requests](https://tools.ietf.org/html/rfc6585#section-4)|Превышен рейтлимит подтверждений|[Error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## logout

<a id="opIdlogout"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/auth/logout \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
POST http://localhost:8080/api/v1/auth/logout HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/auth/logout',
{
  method: 'POST',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.post 'http://localhost:8080/api/v1/auth/logout',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json',
  'Authorization': 'Bearer {access-token}'
}

r = requests.post('http://localhost:8080/api/v1/auth/logout', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/v1/auth/logout', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/auth/logout");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/auth/logout", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/auth/logout`

*Выйти из аккаунта*

Инвалидирует текущий opaque токен доступа, переданный в заголовке Authorization

> Example responses

> 401 Response

```json
{
  "code": "INVALID_TOKEN",
  "message": "Токен отсутствует, недействителен или истек"
}
```

<h3 id="logout-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|204|[No Content](https://tools.ietf.org/html/rfc7231#section-6.3.5)|Токен успешно инвалидирован|None|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Токен отсутствует, недействителен или истек|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

<h1 id="t-learn-api-statistics">statistics</h1>

Статистика обучения пользователя

## getMemorizedWordsPerDay

<a id="opIdgetMemorizedWordsPerDay"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/statistics/memorized-per-day \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
GET http://localhost:8080/api/v1/statistics/memorized-per-day HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/statistics/memorized-per-day',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.get 'http://localhost:8080/api/v1/statistics/memorized-per-day',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json',
  'Authorization': 'Bearer {access-token}'
}

r = requests.get('http://localhost:8080/api/v1/statistics/memorized-per-day', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/v1/statistics/memorized-per-day', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/statistics/memorized-per-day");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/statistics/memorized-per-day", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/statistics/memorized-per-day`

*Количество выученных слов по дням*

<h3 id="getmemorizedwordsperday-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|from|query|string(date)|false|Начало периода (включительно)|
|to|query|string(date)|false|Конец периода (включительно)|

> Example responses

> 200 Response

```json
[
  {
    "date": "2026-11-07",
    "count": 6
  }
]
```

> Некорректный период

```json
{
  "code": "STATISTICS_INVALID_PERIOD",
  "message": "Дата from позже даты to"
}
```

> 401 Response

```json
{
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

<h3 id="getmemorizedwordsperday-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Выученные слова по дням (возвращаются только дни с ненулевым значением)|[MemorizedPerDayResponse](#schemamemorizedperdayresponse)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Некорректный период|[Error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## getVocabularyStatistics

<a id="opIdgetVocabularyStatistics"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/statistics/vocabularies/{vocabularyId}/progress \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
GET http://localhost:8080/api/v1/statistics/vocabularies/{vocabularyId}/progress HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/statistics/vocabularies/{vocabularyId}/progress',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.get 'http://localhost:8080/api/v1/statistics/vocabularies/{vocabularyId}/progress',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json',
  'Authorization': 'Bearer {access-token}'
}

r = requests.get('http://localhost:8080/api/v1/statistics/vocabularies/{vocabularyId}/progress', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/v1/statistics/vocabularies/{vocabularyId}/progress', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/statistics/vocabularies/{vocabularyId}/progress");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/statistics/vocabularies/{vocabularyId}/progress", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/statistics/vocabularies/{vocabularyId}/progress`

*Прогресс пользователя по словарю*

<h3 id="getvocabularystatistics-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|vocabularyId|path|integer(int64)|true|Идентификатор словаря|

> Example responses

> 200 Response

```json
{
  "alreadyKnow": 52,
  "inProgress": 1,
  "memorized": 7,
  "remaining": 25,
  "total": 1488
}
```

> 401 Response

```json
{
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 404 Response

```json
{
  "code": "NOT_FOUND",
  "message": "Ресурс не найден"
}
```

<h3 id="getvocabularystatistics-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Счётчики прогресса пользователя по словарю|[VocabProgressResponse](#schemavocabprogressresponse)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Ресурс не найден|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

<h1 id="t-learn-api-admin">admin</h1>

Эндпоинты панели администратора

## getAdminUserStatistics

<a id="opIdgetAdminUserStatistics"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/admin/statistics/users/{userId} \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
GET http://localhost:8080/api/v1/admin/statistics/users/{userId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/admin/statistics/users/{userId}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.get 'http://localhost:8080/api/v1/admin/statistics/users/{userId}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json',
  'Authorization': 'Bearer {access-token}'
}

r = requests.get('http://localhost:8080/api/v1/admin/statistics/users/{userId}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/v1/admin/statistics/users/{userId}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/admin/statistics/users/{userId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/admin/statistics/users/{userId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/admin/statistics/users/{userId}`

*Статистика пользователя*

<h3 id="getadminuserstatistics-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|userId|path|integer(int64)|true|Идентификатор пользователя|
|from|query|string(date)|false|Начало периода (включительно)|
|to|query|string(date)|false|Конец периода (включительно)|

> Example responses

> 200 Response

```json
{
  "userId": 0,
  "memorizedPerDay": [
    {
      "date": "2026-11-07",
      "count": 6
    }
  ],
  "vocabularies": [
    {
      "alreadyKnow": 52,
      "inProgress": 1,
      "memorized": 7,
      "remaining": 25,
      "total": 1488,
      "vocabularyId": 0
    }
  ]
}
```

> Некорректный период

```json
{
  "code": "STATISTICS_INVALID_PERIOD",
  "message": "Дата from позже даты to"
}
```

> 401 Response

```json
{
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 404 Response

```json
{
  "code": "NOT_FOUND",
  "message": "Ресурс не найден"
}
```

<h3 id="getadminuserstatistics-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Вся статистика пользователя|[AdminUserStatisticsResponse](#schemaadminuserstatisticsresponse)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Некорректный период|[Error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Ресурс не найден|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

# Schemas

<h2 id="tocS_SendOtpRequest">SendOtpRequest</h2>
<!-- backwards compatibility -->
<a id="schemasendotprequest"></a>
<a id="schema_SendOtpRequest"></a>
<a id="tocSsendotprequest"></a>
<a id="tocssendotprequest"></a>

```json
{
  "email": "user@example.com"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|email|string(email)|true|none|Почта, на которую отправляется код|

<h2 id="tocS_SendOtpResponse">SendOtpResponse</h2>
<!-- backwards compatibility -->
<a id="schemasendotpresponse"></a>
<a id="schema_SendOtpResponse"></a>
<a id="tocSsendotpresponse"></a>
<a id="tocssendotpresponse"></a>

```json
{
  "requestId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "expiresIn": 300,
  "retryAfter": 60
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|requestId|string(uuid)|true|none|Идентификатор отправки|
|expiresIn|integer(int32)|true|none|Время жизни кода в секундах|
|retryAfter|integer(int32)|true|none|Через сколько секунд можно запросить код повторно|

<h2 id="tocS_Error">Error</h2>
<!-- backwards compatibility -->
<a id="schemaerror"></a>
<a id="schema_Error"></a>
<a id="tocSerror"></a>
<a id="tocserror"></a>

```json
{
  "code": "VALIDATION_ERROR",
  "message": "Некорректное значение поля"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|code|string|true|none|Машиночитаемый код ошибки, стабильная константа для обработки на клиенте|
|message|string|true|none|Человекочитаемое описание ошибки|

<h2 id="tocS_VerifyRequest">VerifyRequest</h2>
<!-- backwards compatibility -->
<a id="schemaverifyrequest"></a>
<a id="schema_VerifyRequest"></a>
<a id="tocSverifyrequest"></a>
<a id="tocsverifyrequest"></a>

```json
{
  "requestId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "code": "483920"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|requestId|string(uuid)|true|none|Идентификатор отправки|
|code|string|true|none|Шестизначный код из письма|

<h2 id="tocS_VerifyResponse">VerifyResponse</h2>
<!-- backwards compatibility -->
<a id="schemaverifyresponse"></a>
<a id="schema_VerifyResponse"></a>
<a id="tocSverifyresponse"></a>
<a id="tocsverifyresponse"></a>

```json
{
  "accessToken": "9f2c1b7a4d6e8f0a3b5c7d9e1f2a4b6c",
  "tokenType": "Bearer",
  "expiresIn": 2592000
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|accessToken|string|true|none|Opaque токен доступа, передается в заголовке Authorization|
|tokenType|string|true|none|Тип токена, всегда Bearer|
|expiresIn|integer(int32)|true|none|Время жизни токена в секундах|

#### Enumerated Values

|Property|Value|
|---|---|
|tokenType|Bearer|

<h2 id="tocS_MemorizedPerDayResponse">MemorizedPerDayResponse</h2>
<!-- backwards compatibility -->
<a id="schemamemorizedperdayresponse"></a>
<a id="schema_MemorizedPerDayResponse"></a>
<a id="tocSmemorizedperdayresponse"></a>
<a id="tocsmemorizedperdayresponse"></a>

```json
[
  {
    "date": "2026-11-07",
    "count": 6
  }
]

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|date|string(date)|true|none|none|
|count|integer(int32)|true|none|none|

<h2 id="tocS_VocabProgressResponse">VocabProgressResponse</h2>
<!-- backwards compatibility -->
<a id="schemavocabprogressresponse"></a>
<a id="schema_VocabProgressResponse"></a>
<a id="tocSvocabprogressresponse"></a>
<a id="tocsvocabprogressresponse"></a>

```json
{
  "alreadyKnow": 52,
  "inProgress": 1,
  "memorized": 7,
  "remaining": 25,
  "total": 1488
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|alreadyKnow|integer(int32)|true|none|Сколько слов пользователь уже знал (не попали в ротацию)|
|inProgress|integer(int32)|true|none|Сколько слов уже попали в ротацию, но пользователь их еще не выучил|
|memorized|integer(int32)|true|none|Сколько слов из числа тех, что попали в ротацию, пользователь выучил|
|remaining|integer(int32)|true|none|Сколько слов из словаря пользователь не видел вообще|
|total|integer(int32)|true|none|Всего слов в словаре|

<h2 id="tocS_AdminUserStatisticsResponse">AdminUserStatisticsResponse</h2>
<!-- backwards compatibility -->
<a id="schemaadminuserstatisticsresponse"></a>
<a id="schema_AdminUserStatisticsResponse"></a>
<a id="tocSadminuserstatisticsresponse"></a>
<a id="tocsadminuserstatisticsresponse"></a>

```json
{
  "userId": 0,
  "memorizedPerDay": [
    {
      "date": "2026-11-07",
      "count": 6
    }
  ],
  "vocabularies": [
    {
      "alreadyKnow": 52,
      "inProgress": 1,
      "memorized": 7,
      "remaining": 25,
      "total": 1488,
      "vocabularyId": 0
    }
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|userId|integer(int64)|true|none|none|
|memorizedPerDay|[MemorizedPerDayResponse](#schemamemorizedperdayresponse)|true|none|none|
|vocabularies|[allOf]|true|none|Статистика по словарям, с которыми пользователь работал|

allOf

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» *anonymous*|[VocabProgressResponse](#schemavocabprogressresponse)|false|none|none|

and

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» *anonymous*|object|false|none|none|
|»» vocabularyId|integer(int64)|true|none|none|

