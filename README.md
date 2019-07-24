<h3>Controle de gastos </h3>

<p>Um sistema completo para controlar contas a pagar e receber, e controlar seus gastos pessoais.
Podem ser incluídos lançamentos, que terão data, valor, se é crédito ou débito.
Opção de ter lançamento recorrente, que se repete a cada semana, quinzena, mês, bimestre.. etc.
Opção de incluir categorias de despesas/receitas para melhor organização.
Relatório de movimento por período, por categoria.</p>


<h5>Payload:</h5>
<code>
{<br>
    "name": "(nome do lançamento)",<br>
    "date": "(data formato yyyy-MM-dd)",<br>
    "amount": (valor),<br>
    "type": "(INPUT/OUTPUT)",<br>
    "recurrent":(true or false),<br>
    "recurringDays":7<br>
}<br>
</code>
