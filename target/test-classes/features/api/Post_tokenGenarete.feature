Feature: Token alma islemi

  Scenario: Kullanıcı giris yaparak token alır

    Given Api Kullanicisi "api/getToken" set eder
    Then Api kullanicisi token islemi icin bir post request yapar
    And Api kullanicisi aldigi tokeni yazdirir