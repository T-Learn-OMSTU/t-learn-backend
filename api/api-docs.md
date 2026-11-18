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

> 403 Response

```json
{
  "code": "FORBIDDEN",
  "message": "Недостаточно прав для выполнения операции"
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
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Доступ запрещён (недостаточно прав)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Ресурс не найден|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

<h1 id="t-learn-api-vocabulary">vocabulary</h1>

Словари для обучения и их администрирование

## importAdminVocabulary

<a id="opIdimportAdminVocabulary"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/admin/vocabularies/import \
  -H 'Content-Type: multipart/form-data' \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
POST http://localhost:8080/api/v1/admin/vocabularies/import HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data
Accept: application/json

```

```javascript
const inputBody = '{
  "name": "Базовый английский",
  "file": "string"
}';
const headers = {
  'Content-Type':'multipart/form-data',
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/admin/vocabularies/import',
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
  'Content-Type' => 'multipart/form-data',
  'Accept' => 'application/json',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.post 'http://localhost:8080/api/v1/admin/vocabularies/import',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'multipart/form-data',
  'Accept': 'application/json',
  'Authorization': 'Bearer {access-token}'
}

r = requests.post('http://localhost:8080/api/v1/admin/vocabularies/import', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'multipart/form-data',
    'Accept' => 'application/json',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/v1/admin/vocabularies/import', array(
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
URL obj = new URL("http://localhost:8080/api/v1/admin/vocabularies/import");
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
        "Content-Type": []string{"multipart/form-data"},
        "Accept": []string{"application/json"},
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/admin/vocabularies/import", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/admin/vocabularies/import`

*Импорт словаря из xls*

> Body parameter

```yaml
name: Базовый английский
file: string

```

<h3 id="importadminvocabulary-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|object|true|none|
|» name|body|string|true|Название создаваемого словаря|
|» file|body|string(binary)|true|xlsx-файл со словами|

> Example responses

> 201 Response

```json
{
  "id": 1,
  "name": "Базовый английский",
  "wordsCount": 1500
}
```

> Ошибка валидации запроса или файла импорта

```json
{
  "code": "VALIDATION_ERROR",
  "message": "Некорректное значение поля"
}
```

```json
{
  "code": "VOCABULARY_IMPORT_INVALID",
  "message": "Строка 17: пустое значение в колонке word"
}
```

> 401 Response

```json
{
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 403 Response

```json
{
  "code": "FORBIDDEN",
  "message": "Недостаточно прав для выполнения операции"
}
```

<h3 id="importadminvocabulary-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Словарь создан и наполнен словами из файла|[VocabularySummary](#schemavocabularysummary)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Ошибка валидации запроса или файла импорта|[Error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Доступ запрещён (недостаточно прав)|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## updateAdminVocabulary

<a id="opIdupdateAdminVocabulary"></a>

> Code samples

```shell
# You can also use wget
curl -X PATCH http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId} \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
PATCH http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "name": "Базовый английский"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}',
{
  method: 'PATCH',
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
  'Accept' => 'application/json',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.patch 'http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json',
  'Authorization': 'Bearer {access-token}'
}

r = requests.patch('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => 'application/json',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PATCH','http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}', array(
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
URL obj = new URL("http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PATCH");
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
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PATCH", "http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PATCH /api/v1/admin/vocabularies/{vocabularyId}`

*Переименование словаря*

> Body parameter

```json
{
  "name": "Базовый английский"
}
```

<h3 id="updateadminvocabulary-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|vocabularyId|path|integer(int64)|true|Идентификатор словаря|
|body|body|[AdminUpdateVocabularyRequest](#schemaadminupdatevocabularyrequest)|true|none|

> Example responses

> 200 Response

```json
{
  "id": 1,
  "name": "Базовый английский",
  "wordsCount": 1500
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
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 403 Response

```json
{
  "code": "FORBIDDEN",
  "message": "Недостаточно прав для выполнения операции"
}
```

> Словарь с указанным vocabularyId не существует

```json
{
  "code": "VOCABULARY_NOT_FOUND",
  "message": "Словарь не найден"
}
```

<h3 id="updateadminvocabulary-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Словарь переименован; возвращается актуальное состояние|[VocabularySummary](#schemavocabularysummary)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Ошибка валидации запроса (невалидное значение поля, отсутствует обязательное поле, нарушен формат данных)|[Error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Доступ запрещён (недостаточно прав)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Словарь с указанным vocabularyId не существует|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## deleteAdminVocabulary

<a id="opIddeleteAdminVocabulary"></a>

> Code samples

```shell
# You can also use wget
curl -X DELETE http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId} \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
DELETE http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}',
{
  method: 'DELETE',

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

result = RestClient.delete 'http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}',
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

r = requests.delete('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}', headers = headers)

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
    $response = $client->request('DELETE','http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}', array(
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
URL obj = new URL("http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
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
    req, err := http.NewRequest("DELETE", "http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`DELETE /api/v1/admin/vocabularies/{vocabularyId}`

*Удаление словаря*

<h3 id="deleteadminvocabulary-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|vocabularyId|path|integer(int64)|true|Идентификатор удаляемого словаря|

> Example responses

> 401 Response

```json
{
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 403 Response

```json
{
  "code": "FORBIDDEN",
  "message": "Недостаточно прав для выполнения операции"
}
```

> Словарь с указанным vocabularyId не существует

```json
{
  "code": "VOCABULARY_NOT_FOUND",
  "message": "Словарь не найден"
}
```

<h3 id="deleteadminvocabulary-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|204|[No Content](https://tools.ietf.org/html/rfc7231#section-6.3.5)|Словарь удалён|None|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Доступ запрещён (недостаточно прав)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Словарь с указанным vocabularyId не существует|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## exportAdminVocabulary

<a id="opIdexportAdminVocabulary"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/export \
  -H 'Accept: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' \
  -H 'Authorization: Bearer {access-token}'

```

```http
GET http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/export HTTP/1.1
Host: localhost:8080
Accept: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet

```

```javascript

const headers = {
  'Accept':'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/export',
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
  'Accept' => 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.get 'http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/export',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
  'Authorization': 'Bearer {access-token}'
}

r = requests.get('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/export', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/export', array(
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
URL obj = new URL("http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/export");
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
        "Accept": []string{"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/export", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/admin/vocabularies/{vocabularyId}/export`

*Выгрузка словаря в xls*

<h3 id="exportadminvocabulary-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|vocabularyId|path|integer(int64)|true|Идентификатор выгружаемого словаря|

> Example responses

> 200 Response

> 401 Response

```json
{
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 403 Response

```json
{
  "code": "FORBIDDEN",
  "message": "Недостаточно прав для выполнения операции"
}
```

> Словарь с указанным vocabularyId не существует

```json
{
  "code": "VOCABULARY_NOT_FOUND",
  "message": "Словарь не найден"
}
```

<h3 id="exportadminvocabulary-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|xlsx-файл со словами словаря|string|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Доступ запрещён (недостаточно прав)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Словарь с указанным vocabularyId не существует|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## getAdminVocabularyWords

<a id="opIdgetAdminVocabularyWords"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
GET http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words',
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

result = RestClient.get 'http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words',
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

r = requests.get('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words', headers = headers)

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
    $response = $client->request('GET','http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words', array(
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
URL obj = new URL("http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words");
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
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/admin/vocabularies/{vocabularyId}/words`

*Слова словаря*

Возвращает постраничный список слов словаря для редактирования в админке.

<h3 id="getadminvocabularywords-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|vocabularyId|path|integer(int64)|true|Идентификатор словаря|
|page|query|integer(int32)|false|Номер страницы, нумерация с 1|
|size|query|integer(int32)|false|Размер страницы; больше 100 записей за раз запросить нельзя|
|search|query|string|false|Подстрока для поиска по word или translation, без учёта регистра|

> Example responses

> 200 Response

```json
{
  "items": [
    {
      "id": 67,
      "word": "feel",
      "transcription": "fil",
      "translation": "чувствовать",
      "type": "NOUN"
    }
  ],
  "total": 1500,
  "page": 1,
  "size": 50
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
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 403 Response

```json
{
  "code": "FORBIDDEN",
  "message": "Недостаточно прав для выполнения операции"
}
```

> Словарь с указанным vocabularyId не существует

```json
{
  "code": "VOCABULARY_NOT_FOUND",
  "message": "Словарь не найден"
}
```

<h3 id="getadminvocabularywords-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Страница списка слов|[AdminWordsListResponse](#schemaadminwordslistresponse)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Ошибка валидации запроса (невалидное значение поля, отсутствует обязательное поле, нарушен формат данных)|[Error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Доступ запрещён (недостаточно прав)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Словарь с указанным vocabularyId не существует|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## createAdminVocabularyWord

<a id="opIdcreateAdminVocabularyWord"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
POST http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "word": "feel",
  "transcription": "fil",
  "translation": "чувствовать",
  "type": "NOUN"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words',
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
  'Accept' => 'application/json',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.post 'http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json',
  'Authorization': 'Bearer {access-token}'
}

r = requests.post('http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => 'application/json',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words', array(
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
URL obj = new URL("http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words");
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
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/admin/vocabularies/{vocabularyId}/words", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/admin/vocabularies/{vocabularyId}/words`

*Добавление слова в словарь*

> Body parameter

```json
{
  "word": "feel",
  "transcription": "fil",
  "translation": "чувствовать",
  "type": "NOUN"
}
```

<h3 id="createadminvocabularyword-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|vocabularyId|path|integer(int64)|true|Идентификатор словаря, в который добавляется слово|
|body|body|[AdminCreateWordRequest](#schemaadmincreatewordrequest)|true|none|

> Example responses

> 201 Response

```json
{
  "id": 67,
  "word": "feel",
  "transcription": "fil",
  "translation": "чувствовать",
  "type": "NOUN"
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
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 403 Response

```json
{
  "code": "FORBIDDEN",
  "message": "Недостаточно прав для выполнения операции"
}
```

> Словарь с указанным vocabularyId не существует

```json
{
  "code": "VOCABULARY_NOT_FOUND",
  "message": "Словарь не найден"
}
```

> Слово с таким написанием уже есть в этом словаре

```json
{
  "code": "VOCABULARY_WORD_DUPLICATE",
  "message": "Слово уже есть в словаре"
}
```

<h3 id="createadminvocabularyword-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Слово добавлено|[Word](#schemaword)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Ошибка валидации запроса (невалидное значение поля, отсутствует обязательное поле, нарушен формат данных)|[Error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Доступ запрещён (недостаточно прав)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Словарь с указанным vocabularyId не существует|[Error](#schemaerror)|
|409|[Conflict](https://tools.ietf.org/html/rfc7231#section-6.5.8)|Слово с таким написанием уже есть в этом словаре|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## updateAdminWord

<a id="opIdupdateAdminWord"></a>

> Code samples

```shell
# You can also use wget
curl -X PATCH http://localhost:8080/api/v1/admin/words/{wordId} \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
PATCH http://localhost:8080/api/v1/admin/words/{wordId} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "word": "feel",
  "transcription": "fil",
  "translation": "чувствовать",
  "type": "NOUN"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/admin/words/{wordId}',
{
  method: 'PATCH',
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
  'Accept' => 'application/json',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.patch 'http://localhost:8080/api/v1/admin/words/{wordId}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json',
  'Authorization': 'Bearer {access-token}'
}

r = requests.patch('http://localhost:8080/api/v1/admin/words/{wordId}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => 'application/json',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PATCH','http://localhost:8080/api/v1/admin/words/{wordId}', array(
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
URL obj = new URL("http://localhost:8080/api/v1/admin/words/{wordId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PATCH");
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
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PATCH", "http://localhost:8080/api/v1/admin/words/{wordId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PATCH /api/v1/admin/words/{wordId}`

*Редактирование слова*

> Body parameter

```json
{
  "word": "feel",
  "transcription": "fil",
  "translation": "чувствовать",
  "type": "NOUN"
}
```

<h3 id="updateadminword-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|wordId|path|integer(int64)|true|Идентификатор слова|
|body|body|[AdminUpdateWordRequest](#schemaadminupdatewordrequest)|true|none|

> Example responses

> 200 Response

```json
{
  "id": 67,
  "word": "feel",
  "transcription": "fil",
  "translation": "чувствовать",
  "type": "NOUN"
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
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 403 Response

```json
{
  "code": "FORBIDDEN",
  "message": "Недостаточно прав для выполнения операции"
}
```

> Слово с указанным wordId не существует

```json
{
  "code": "VOCABULARY_WORD_NOT_FOUND",
  "message": "Слово не найдено"
}
```

> Слово с таким написанием уже есть в этом словаре

```json
{
  "code": "VOCABULARY_WORD_DUPLICATE",
  "message": "Слово уже есть в словаре"
}
```

<h3 id="updateadminword-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Слово обновлено; возвращается актуальное состояние|[Word](#schemaword)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Ошибка валидации запроса (невалидное значение поля, отсутствует обязательное поле, нарушен формат данных)|[Error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Доступ запрещён (недостаточно прав)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Слово с указанным wordId не существует|[Error](#schemaerror)|
|409|[Conflict](https://tools.ietf.org/html/rfc7231#section-6.5.8)|Слово с таким написанием уже есть в этом словаре|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## deleteAdminWord

<a id="opIddeleteAdminWord"></a>

> Code samples

```shell
# You can also use wget
curl -X DELETE http://localhost:8080/api/v1/admin/words/{wordId} \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
DELETE http://localhost:8080/api/v1/admin/words/{wordId} HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/admin/words/{wordId}',
{
  method: 'DELETE',

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

result = RestClient.delete 'http://localhost:8080/api/v1/admin/words/{wordId}',
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

r = requests.delete('http://localhost:8080/api/v1/admin/words/{wordId}', headers = headers)

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
    $response = $client->request('DELETE','http://localhost:8080/api/v1/admin/words/{wordId}', array(
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
URL obj = new URL("http://localhost:8080/api/v1/admin/words/{wordId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
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
    req, err := http.NewRequest("DELETE", "http://localhost:8080/api/v1/admin/words/{wordId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`DELETE /api/v1/admin/words/{wordId}`

*Удаление слова*

<h3 id="deleteadminword-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|wordId|path|integer(int64)|true|Идентификатор удаляемого слова|

> Example responses

> 401 Response

```json
{
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

> 403 Response

```json
{
  "code": "FORBIDDEN",
  "message": "Недостаточно прав для выполнения операции"
}
```

> Слово с указанным wordId не существует

```json
{
  "code": "VOCABULARY_WORD_NOT_FOUND",
  "message": "Слово не найдено"
}
```

<h3 id="deleteadminword-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|204|[No Content](https://tools.ietf.org/html/rfc7231#section-6.3.5)|Слово удалено|None|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|Доступ запрещён (недостаточно прав)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Слово с указанным wordId не существует|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

<h1 id="t-learn-api-learning">learning</h1>

Обучение по карточкам и прогресс повторений

## getLearningNextCard

<a id="opIdgetLearningNextCard"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/learning/cards/next \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
GET http://localhost:8080/api/v1/learning/cards/next HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/learning/cards/next',
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

result = RestClient.get 'http://localhost:8080/api/v1/learning/cards/next',
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

r = requests.get('http://localhost:8080/api/v1/learning/cards/next', headers = headers)

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
    $response = $client->request('GET','http://localhost:8080/api/v1/learning/cards/next', array(
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
URL obj = new URL("http://localhost:8080/api/v1/learning/cards/next");
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
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/learning/cards/next", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/learning/cards/next`

*Следующая карточка обучения*

> Example responses

> 200 Response

```json
{
  "cardType": "NEW",
  "direction": "EN_RU",
  "word": {
    "id": 67,
    "word": "feel",
    "transcription": "fil",
    "translation": "чувствовать",
    "type": "NOUN"
  }
}
```

> 401 Response

```json
{
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

<h3 id="getlearningnextcard-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Следующая карточка.|[Card](#schemacard)|
|204|[No Content](https://tools.ietf.org/html/rfc7231#section-6.3.5)|Нет карточек для показа (всё выучено, ротация не дозрела или словарь пуст).|None|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## answerLearningWord

<a id="opIdanswerLearningWord"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/learning/words/{wordId}/answer \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
POST http://localhost:8080/api/v1/learning/words/{wordId}/answer HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "action": "REMEMBERED",
  "expectedStage": 3
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/learning/words/{wordId}/answer',
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
  'Accept' => 'application/json',
  'Authorization' => 'Bearer {access-token}'
}

result = RestClient.post 'http://localhost:8080/api/v1/learning/words/{wordId}/answer',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json',
  'Authorization': 'Bearer {access-token}'
}

r = requests.post('http://localhost:8080/api/v1/learning/words/{wordId}/answer', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => 'application/json',
    'Authorization' => 'Bearer {access-token}',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/v1/learning/words/{wordId}/answer', array(
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
URL obj = new URL("http://localhost:8080/api/v1/learning/words/{wordId}/answer");
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
        "Authorization": []string{"Bearer {access-token}"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/learning/words/{wordId}/answer", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/learning/words/{wordId}/answer`

*Ответ на карточку*

> Body parameter

```json
{
  "action": "REMEMBERED",
  "expectedStage": 3
}
```

<h3 id="answerlearningword-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|wordId|path|integer(int64)|true|Слово, по которому отправляется ответ (из карточки).|
|body|body|[AnswerRequest](#schemaanswerrequest)|true|none|

> Example responses

> 200 Response

```json
{
  "id": 12345,
  "status": "IN_ROTATION",
  "stage": 4,
  "dueAt": "2026-11-19T10:30:00Z"
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

> Действие не соответствует текущему состоянию слова на сервере.

```json
{
  "code": "LEARNING_ACTION_NOT_ALLOWED",
  "message": "Действие недопустимо для текущего состояния слова"
}
```

```json
{
  "code": "LEARNING_STAGE_CONFLICT",
  "message": "Состояние слова изменилось, запросите карточку заново"
}
```

<h3 id="answerlearningword-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Ответ принят, актуальное состояние прогресса по слову.|[AnswerResponse](#schemaanswerresponse)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Ошибка валидации запроса (невалидное значение поля, отсутствует обязательное поле, нарушен формат данных)|[Error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Ресурс не найден|[Error](#schemaerror)|
|409|[Conflict](https://tools.ietf.org/html/rfc7231#section-6.5.8)|Действие не соответствует текущему состоянию слова на сервере.|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## resetLearningVocabularyProgress

<a id="opIdresetLearningVocabularyProgress"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/learning/progress/vocabularies/{vocabularyId}/reset \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
POST http://localhost:8080/api/v1/learning/progress/vocabularies/{vocabularyId}/reset HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/learning/progress/vocabularies/{vocabularyId}/reset',
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

result = RestClient.post 'http://localhost:8080/api/v1/learning/progress/vocabularies/{vocabularyId}/reset',
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

r = requests.post('http://localhost:8080/api/v1/learning/progress/vocabularies/{vocabularyId}/reset', headers = headers)

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
    $response = $client->request('POST','http://localhost:8080/api/v1/learning/progress/vocabularies/{vocabularyId}/reset', array(
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
URL obj = new URL("http://localhost:8080/api/v1/learning/progress/vocabularies/{vocabularyId}/reset");
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
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/learning/progress/vocabularies/{vocabularyId}/reset", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/learning/progress/vocabularies/{vocabularyId}/reset`

*Сброс прогресса по словарю*

<h3 id="resetlearningvocabularyprogress-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|vocabularyId|path|integer(int64)|true|Словарь, по которому сбрасывается прогресс.|

> Example responses

> 200 Response

```json
{
  "resetCount": 52
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

<h3 id="resetlearningvocabularyprogress-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Прогресс по словарю сброшен.|[ResetProgressResponse](#schemaresetprogressresponse)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Ресурс не найден|[Error](#schemaerror)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth
</aside>

## resetLearningAllProgress

<a id="opIdresetLearningAllProgress"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/learning/progress/reset-all \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer {access-token}'

```

```http
POST http://localhost:8080/api/v1/learning/progress/reset-all HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json',
  'Authorization':'Bearer {access-token}'
};

fetch('http://localhost:8080/api/v1/learning/progress/reset-all',
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

result = RestClient.post 'http://localhost:8080/api/v1/learning/progress/reset-all',
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

r = requests.post('http://localhost:8080/api/v1/learning/progress/reset-all', headers = headers)

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
    $response = $client->request('POST','http://localhost:8080/api/v1/learning/progress/reset-all', array(
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
URL obj = new URL("http://localhost:8080/api/v1/learning/progress/reset-all");
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
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/learning/progress/reset-all", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/learning/progress/reset-all`

*Сброс всего прогресса обучения*

> Example responses

> 200 Response

```json
{
  "resetCount": 52
}
```

> 401 Response

```json
{
  "code": "UNAUTHORIZED",
  "message": "Требуется авторизация"
}
```

<h3 id="resetlearningallprogress-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Весь прогресс обучения сброшен.|[ResetProgressResponse](#schemaresetprogressresponse)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Не авторизован (токен отсутствует или недействителен)|[Error](#schemaerror)|

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

<h2 id="tocS_VocabularySummary">VocabularySummary</h2>
<!-- backwards compatibility -->
<a id="schemavocabularysummary"></a>
<a id="schema_VocabularySummary"></a>
<a id="tocSvocabularysummary"></a>
<a id="tocsvocabularysummary"></a>

```json
{
  "id": 1,
  "name": "Базовый английский",
  "wordsCount": 1500
}

```

Словарь в каталоге - набор слов для обучения

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int64)|true|none|Идентификатор словаря|
|name|string|true|none|Название словаря, отображается пользователю при выборе|
|wordsCount|integer(int32)|true|none|Количество слов в словаре|

<h2 id="tocS_AdminUpdateVocabularyRequest">AdminUpdateVocabularyRequest</h2>
<!-- backwards compatibility -->
<a id="schemaadminupdatevocabularyrequest"></a>
<a id="schema_AdminUpdateVocabularyRequest"></a>
<a id="tocSadminupdatevocabularyrequest"></a>
<a id="tocsadminupdatevocabularyrequest"></a>

```json
{
  "name": "Базовый английский"
}

```

Изменения словаря

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|true|none|Новое название словаря, отображается пользователю при выборе|

<h2 id="tocS_Word">Word</h2>
<!-- backwards compatibility -->
<a id="schemaword"></a>
<a id="schema_Word"></a>
<a id="tocSword"></a>
<a id="tocsword"></a>

```json
{
  "id": 67,
  "word": "feel",
  "transcription": "fil",
  "translation": "чувствовать",
  "type": "NOUN"
}

```

Слово словаря

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int64)|true|none|Идентификатор слова|
|word|string|true|none|Английское написание слова|
|transcription|string|true|none|Транскрипция английского слова|
|translation|string|true|none|Перевод на русский|
|type|string|true|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|type|NOUN|
|type|ADJECTIVE|
|type|VERB|
|type|PRONOUN|
|type|ADVERB|

<h2 id="tocS_AdminWordsListResponse">AdminWordsListResponse</h2>
<!-- backwards compatibility -->
<a id="schemaadminwordslistresponse"></a>
<a id="schema_AdminWordsListResponse"></a>
<a id="tocSadminwordslistresponse"></a>
<a id="tocsadminwordslistresponse"></a>

```json
{
  "items": [
    {
      "id": 67,
      "word": "feel",
      "transcription": "fil",
      "translation": "чувствовать",
      "type": "NOUN"
    }
  ],
  "total": 1500,
  "page": 1,
  "size": 50
}

```

Страница списка слов словаря

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|items|[[Word](#schemaword)]|true|none|Слова текущей страницы; пустой массив, если страница за пределами диапазона|
|total|integer(int32)|true|none|Общее число слов в словаре с учётом фильтра search; фронту нужно для отрисовки|
|page|integer(int32)|true|none|Номер возвращённой страницы|
|size|integer(int32)|true|none|Размер страницы|

<h2 id="tocS_AdminCreateWordRequest">AdminCreateWordRequest</h2>
<!-- backwards compatibility -->
<a id="schemaadmincreatewordrequest"></a>
<a id="schema_AdminCreateWordRequest"></a>
<a id="tocSadmincreatewordrequest"></a>
<a id="tocsadmincreatewordrequest"></a>

```json
{
  "word": "feel",
  "transcription": "fil",
  "translation": "чувствовать",
  "type": "NOUN"
}

```

Слово словаря (без id для создания в словаре)

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|word|string|true|none|Английское написание слова|
|transcription|string|true|none|Транскрипция английского слова|
|translation|string|true|none|Перевод на русский|
|type|string|true|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|type|NOUN|
|type|ADJECTIVE|
|type|VERB|
|type|PRONOUN|
|type|ADVERB|

<h2 id="tocS_AdminUpdateWordRequest">AdminUpdateWordRequest</h2>
<!-- backwards compatibility -->
<a id="schemaadminupdatewordrequest"></a>
<a id="schema_AdminUpdateWordRequest"></a>
<a id="tocSadminupdatewordrequest"></a>
<a id="tocsadminupdatewordrequest"></a>

```json
{
  "word": "feel",
  "transcription": "fil",
  "translation": "чувствовать",
  "type": "NOUN"
}

```

Изменения слова; передаются только изменяемые поля, минимум одно

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|word|string|false|none|Английское написание слова|
|transcription|string|false|none|Транскрипция английского слова|
|translation|string|false|none|Перевод на русский|
|type|string|false|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|type|NOUN|
|type|ADJECTIVE|
|type|VERB|
|type|PRONOUN|
|type|ADVERB|

<h2 id="tocS_NewCard">NewCard</h2>
<!-- backwards compatibility -->
<a id="schemanewcard"></a>
<a id="schema_NewCard"></a>
<a id="tocSnewcard"></a>
<a id="tocsnewcard"></a>

```json
{
  "cardType": "NEW",
  "direction": "EN_RU",
  "word": {
    "id": 67,
    "word": "feel",
    "transcription": "fil",
    "translation": "чувствовать",
    "type": "NOUN"
  }
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|cardType|string|true|none|none|
|direction|string|true|none|none|
|word|[Word](#schemaword)|true|none|Слово словаря|

#### Enumerated Values

|Property|Value|
|---|---|
|cardType|NEW|
|direction|EN_RU|

<h2 id="tocS_RotationCard">RotationCard</h2>
<!-- backwards compatibility -->
<a id="schemarotationcard"></a>
<a id="schema_RotationCard"></a>
<a id="tocSrotationcard"></a>
<a id="tocsrotationcard"></a>

```json
{
  "cardType": "ROTATION",
  "direction": "EN_RU",
  "word": {
    "id": 67,
    "word": "feel",
    "transcription": "fil",
    "translation": "чувствовать",
    "type": "NOUN"
  },
  "stage": 3,
  "totalStages": 8,
  "penaltyStep": 0
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|cardType|string|true|none|none|
|direction|string|true|none|Направление перевода, выбирается сервером случайно при каждом показе|
|word|[Word](#schemaword)|true|none|Слово словаря|
|stage|integer(int32)|true|none|Текущий этап повторения (отображается в углу карточки)|
|totalStages|integer(int32)|true|none|Всего этапов повторения до статуса «выучено»|
|penaltyStep|integer(int32)|true|none|Шаг штрафного повторения после «не запомнил» (0 — не в штрафе, 1 — повтор через 5 минут, 2 — через 1 час)|

#### Enumerated Values

|Property|Value|
|---|---|
|cardType|ROTATION|
|direction|EN_RU|
|direction|RU_EN|
|penaltyStep|0|
|penaltyStep|1|
|penaltyStep|2|

<h2 id="tocS_Card">Card</h2>
<!-- backwards compatibility -->
<a id="schemacard"></a>
<a id="schema_Card"></a>
<a id="tocScard"></a>
<a id="tocscard"></a>

```json
{
  "cardType": "NEW",
  "direction": "EN_RU",
  "word": {
    "id": 67,
    "word": "feel",
    "transcription": "fil",
    "translation": "чувствовать",
    "type": "NOUN"
  }
}

```

### Properties

oneOf

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[NewCard](#schemanewcard)|false|none|none|

xor

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[RotationCard](#schemarotationcard)|false|none|none|

<h2 id="tocS_AnswerRequest">AnswerRequest</h2>
<!-- backwards compatibility -->
<a id="schemaanswerrequest"></a>
<a id="schema_AnswerRequest"></a>
<a id="tocSanswerrequest"></a>
<a id="tocsanswerrequest"></a>

```json
{
  "action": "REMEMBERED",
  "expectedStage": 3
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|action|string|true|none|none|
|expectedStage|integer(int32)|false|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|action|KNOW|
|action|UNKNOWN|
|action|REMEMBERED|
|action|FORGOT|

<h2 id="tocS_AnswerResponse">AnswerResponse</h2>
<!-- backwards compatibility -->
<a id="schemaanswerresponse"></a>
<a id="schema_AnswerResponse"></a>
<a id="tocSanswerresponse"></a>
<a id="tocsanswerresponse"></a>

```json
{
  "id": 12345,
  "status": "IN_ROTATION",
  "stage": 4,
  "dueAt": "2026-11-19T10:30:00Z"
}

```

Актуальное состояние прогресса по слову после обработки ответа.

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int64)|true|none|none|
|status|string|true|none|none|
|stage|integer(int32)|true|none|none|
|dueAt|string(date-time)¦null|true|none|Когда карточка дозреет к показу. null для KNOWN, LEARNED.|

#### Enumerated Values

|Property|Value|
|---|---|
|status|KNOWN|
|status|IN_ROTATION|
|status|LEARNED|

<h2 id="tocS_ResetProgressResponse">ResetProgressResponse</h2>
<!-- backwards compatibility -->
<a id="schemaresetprogressresponse"></a>
<a id="schema_ResetProgressResponse"></a>
<a id="tocSresetprogressresponse"></a>
<a id="tocsresetprogressresponse"></a>

```json
{
  "resetCount": 52
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|resetCount|integer(int32)|true|none|Количество удалённых записей прогресса. 0 — прогресса не было|

