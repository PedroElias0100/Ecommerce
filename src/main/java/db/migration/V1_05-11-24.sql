select constraint_name from information_schema.constraint_column_usage 
where table_name = 'usuarios_acesso' and column_name = 'acesso_id'
and constraint_name <> 'unique_acesso_user';

alter table usuarios_acesso drop CONSTRAINT "uk8bak9jswon2id2jbunuqlfl9e";



CREATE TRIGGER validachavepessoaavaliacaopessoa2
  BEFORE insert
  ON public.avaliacao_produto
  FOR EACH ROW
  EXECUTE PROCEDURE public.validachavepessoa();

CREATE OR REPLACE FUNCTION validachavepessoa()
  RETURNS trigger 
  LANGUAGE PLPGSQL 
AS $$
declare existe integer;

begin 

   existe = (select count(1) from pessoa_fisica where id = NEW.pessoa_id);
   if(existe <= 0) then
    existe = (select count(1) from pessoa_juridica where id = NEW.pessoa_id);
   if (existe <= 0) then
    raise exception 'Não foi encontrado o ID ou a PK da pessoa para realizar a associação';
    end if;
   end if;
RETURN NEW;
end;
$$
CREATE OR REPLACE FUNCTION validachavepessoa2()
  RETURNS trigger 
  LANGUAGE PLPGSQL 
AS $$
declare existe integer;

begin 

   existe = (select count(1) from pessoa_fisica where id = NEW.pessoa_forn_id);
   if(existe <= 0) then
    existe = (select count(1) from pessoa_juridica where id = NEW.pessoa_forn_id);
   if (existe <= 0) then
    raise exception 'Não foi encontrado o ID ou a PK da pessoa para realizar a associação';
    end if;
   end if;
RETURN NEW;
end;
$$

CREATE trigger validaChavepessoaContaPagar
  BEFORE update
  ON public.conta_pagar
  FOR EACH ROW
  EXECUTE PROCEDURE public.validachavepessoa();

CREATE trigger validaChavepessoaContaPagar2
  BEFORE insert
  ON public.conta_pagar
  FOR EACH ROW
  EXECUTE PROCEDURE public.validachavepessoa();

CREATE trigger validaChavepessoaContaPagarPessoa_forn_id
  BEFORE update
  ON public.conta_pagar
  FOR EACH ROW
  EXECUTE PROCEDURE public.validachavepessoa2();

CREATE trigger validaChavepessoaContaPagarPessoa_forn_id2
  BEFORE insert
  ON public.conta_pagar
  FOR EACH ROW
  EXECUTE PROCEDURE public.validachavepessoa2();

CREATE trigger validaChavepessoa
  BEFORE insert
  ON public.vd_cp_loja_virt
  FOR EACH ROW
  EXECUTE PROCEDURE public.validachavepessoa();

CREATE trigger validaChavepessoa2
  BEFORE update
  ON public.vd_cp_loja_virt
  FOR EACH ROW
  EXECUTE PROCEDURE public.validachavepessoa();