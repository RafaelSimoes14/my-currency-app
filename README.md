# MyCurrencyApp

## Descrição do projeto

O **MyCurrencyApp** é um aplicativo Android desenvolvido em **Kotlin** para realizar conversões entre moedas.

A aplicação consome uma API pública de câmbio para obter as taxas atualizadas e permite que o usuário selecione a moeda de origem, a moeda de destino e informe o valor que deseja converter.

O projeto foi desenvolvido com o objetivo de demonstrar a implementação de um aplicativo Android simples consumindo uma API externa, aplicando boas práticas de organização de código e arquitetura.

---

## Screenshots

<p align="center">
  <img src="https://github.com/user-attachments/assets/b17c5a59-eb6c-443b-a3d8-82b37ca0bd31" width="220"/>
  <img src="https://github.com/user-attachments/assets/e913a591-89da-48b6-849c-cd9dfae59b63" width="220"/>
  <img src="https://github.com/user-attachments/assets/66363608-82c9-472e-b1fb-70efef8d49a2" width="220"/>
</p>

<p align="center">
  Inicialização • Tela inicial • Resultado
</p>

---

## Passos para rodar o app

1. Clone o repositório

```bash
git clone https://github.com/RafaelSimoes14/my-currency-app.git
```
2. Abra o projeto no **Android Studio**

3. Aguarde a sincronização do **Gradle**

4. Execute o aplicativo em um **emulador** ou **dispositivo físico**

---

## API utilizada

O aplicativo utiliza a API pública de taxas de câmbio:

https://open.er-api.com/

Endpoint utilizado no projeto:

```bash
https://open.er-api.com/v6/latest/{BASE_CURRENCY}
```

Exemplo de chamada:

```bash
https://open.er-api.com/v6/latest/USD
```

A API retorna um JSON contendo as taxas de conversão entre moedas com base na moeda selecionada.

---

## Decisões técnicas

Algumas decisões técnicas foram tomadas para manter o projeto organizado e facilitar sua evolução:

- Utilização da arquitetura **MVVM** para separar a lógica de interface da lógica de negócio.
- Organização do projeto em camadas inspirada em **Clean Architecture**.
- Uso do **Retrofit** para realizar o consumo da API.
- Uso de **Coroutines** para executar chamadas de rede de forma assíncrona.
- Persistência local utilizando **Room**, evitando chamadas desnecessárias à API.
- Utilização de **ViewBinding** para simplificar o acesso aos componentes da interface.

---

## Possíveis melhorias do projeto

Com mais tempo, algumas melhorias poderiam ser implementadas:

- Adição de **testes unitários**.
- Implementação de **testes de interface (UI tests)**.
- Melhor tratamento de **erros de rede** e estados da aplicação.
- Evolução da implementação do **Room**, incluindo melhor controle de atualização e sincronização entre dados locais e dados da API.
- Substituição do **Spinner** por uma solução mais flexível (por exemplo um BottomSheet com RecyclerView) para melhorar a experiência de seleção das moedas.
- Migração da interface baseada em XML para **Jetpack Compose**.

## Autor
Rafael Simões Rosa
