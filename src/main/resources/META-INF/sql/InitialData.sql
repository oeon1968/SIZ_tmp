/*account managers */
INSERT INTO SIZ.account_managers (id, first_name, last_name) VALUES (1, 'Daniel', 'B');
INSERT INTO SIZ.account_managers (id, first_name, last_name) VALUES (2, 'Małgorzata', 'R');
INSERT INTO SIZ.account_managers (id, first_name, last_name) VALUES (3, 'Magdalena', 'L');

/* project managers */
INSERT INTO SIZ.project_managers (id, first_name, last_name) VALUES (1, 'Karolina', 'K');
INSERT INTO SIZ.project_managers (id, first_name, last_name) VALUES (2, 'Mikołaj', 'K');
INSERT INTO SIZ.project_managers (id, first_name, last_name) VALUES (3, 'Rafał', 'S');


/* client types */
INSERT INTO SIZ.client_types (id, type_name) VALUES (1, 'BANK');
INSERT INTO SIZ.client_types (id, type_name) VALUES (2, 'BANK SPÓŁDZIELCZY');
INSERT INTO SIZ.client_types (id, type_name) VALUES (3, 'DOM MAKLERSKI');
INSERT INTO SIZ.client_types (id, type_name) VALUES (4, 'INNA INSTYTUCJA FINANSOWA');
INSERT INTO SIZ.client_types (id, type_name) VALUES (5, 'INNE');
INSERT INTO SIZ.client_types (id, type_name) VALUES (6, 'INSTYTUCJA PAŃSTWOWA');
INSERT INTO SIZ.client_types (id, type_name) VALUES (7, 'TFI');
INSERT INTO SIZ.client_types (id, type_name) VALUES (8, 'TOWARZYSTWO UBEZPIECZENIOWE');


/* clients */
INSERT INTO SIZ.clients (id, cl_abbreviation, cl_name, acc_mgr_id, cl_type_id) VALUES (1, 'AAREAL', 'Aareal Bank AG ', 2, 1);
INSERT INTO SIZ.clients (id, cl_abbreviation, cl_name, acc_mgr_id, cl_type_id) VALUES (2, 'ALIOR', 'Alior Bank SA', 3, 1);
INSERT INTO SIZ.clients (id, cl_abbreviation, cl_name, acc_mgr_id, cl_type_id) VALUES (3, 'BGK', 'Bank Gospodarstwa Krajowego', 3, 1);
INSERT INTO SIZ.clients (id, cl_abbreviation, cl_name, acc_mgr_id, cl_type_id) VALUES (4, 'AXA', 'TUnŻ AXA Życie Towarzystwo Ubezpieczeń SA', 3, 8);
INSERT INTO SIZ.clients (id, cl_abbreviation, cl_name, acc_mgr_id, cl_type_id) VALUES (5, 'DMBOŚ', 'Dom Maklerski Banku Ochrony Środowiska', 2, 3);


/*contract types */
INSERT INTO SIZ.contract_types (id, ctr_name) VALUES (1, 'WDROŻENIE');
INSERT INTO SIZ.contract_types (id, ctr_name) VALUES (2, 'SERWIS');
INSERT INTO SIZ.contract_types (id, ctr_name) VALUES (3, 'ZLECENIE');
INSERT INTO SIZ.contract_types (id, ctr_name) VALUES (4, 'TOWAR');
INSERT INTO SIZ.contract_types (id, ctr_name) VALUES (5, 'INNE');

/* payment methods */
INSERT INTO SIZ.payment_methods (id, payment_method) VALUES (1, 'JEDNORAZOWO');
INSERT INTO SIZ.payment_methods (id, payment_method) VALUES (2, 'ROCZNIE Z GÓRY');
INSERT INTO SIZ.payment_methods (id, payment_method) VALUES (3, 'ROCZNIE Z DOŁU');
INSERT INTO SIZ.payment_methods (id, payment_method) VALUES (4, 'KWARTALNIE Z GÓRY');
INSERT INTO SIZ.payment_methods (id, payment_method) VALUES (5, 'KWARTALNIE Z DOŁU');
INSERT INTO SIZ.payment_methods (id, payment_method) VALUES (6, 'MIESIĘCZNIE Z GÓRY');
INSERT INTO SIZ.payment_methods (id, payment_method) VALUES (7, 'MIESIĘCZNIE Z DOŁU');

/* product groups */
INSERT INTO SIZ.product_groups (id, group_name) VALUES (1, 'CLOUD COMPUTING');
INSERT INTO SIZ.product_groups (id, group_name) VALUES (2, 'COMPLIANCE I NADUŻYCIA');
INSERT INTO SIZ.product_groups (id, group_name) VALUES (3, 'INNE');
INSERT INTO SIZ.product_groups (id, group_name) VALUES (4, 'KRYPTOGRAFIA I BEZPIECZEŃSTWO');
INSERT INTO SIZ.product_groups (id, group_name) VALUES (5, 'ROZLICZENIA MIĘDZYBANKOWE');
INSERT INTO SIZ.product_groups (id, group_name) VALUES (6, 'RYZYKO OPERACYJNE');
INSERT INTO SIZ.product_groups (id, group_name) VALUES (7, 'SPRAWOZDAWCZOŚĆ');
INSERT INTO SIZ.product_groups (id, group_name) VALUES (8, 'USŁUGI PROGRAMISTYCZNE');
INSERT INTO SIZ.product_groups (id, group_name) VALUES (9, 'idMANAGMENT');

/* products */
INSERT INTO SIZ.products (id, pr_name, product_group_id) VALUES (3, 'amlSPERT', 2);
INSERT INTO SIZ.products (id, pr_name, product_group_id) VALUES (4, 'suiteOBLIGO', 7);
INSERT INTO SIZ.products (id, pr_name, product_group_id) VALUES (5, 'Rejestr Akcjonariuszy', 7);
INSERT INTO SIZ.products (id, pr_name, product_group_id) VALUES (6, 'SI Emeryt', 8);
INSERT INTO SIZ.products (id, pr_name, product_group_id) VALUES (7, 'idGUARD', 9);

/* sectors */
INSERT INTO SIZ.sectors (id, sector_name) VALUES (1, 'BANKOWY');
INSERT INTO SIZ.sectors (id, sector_name) VALUES (2, 'NARODOWY BANK POLSKI');
INSERT INTO SIZ.sectors (id, sector_name) VALUES (3, 'PUBLICZNY');
INSERT INTO SIZ.sectors (id, sector_name) VALUES (4, 'UBEZPIECZENIOWY');

/* contracts*/
INSERT INTO SIZ.contracts (id, accountNo, activeContract, contractFinish, contractNo, contractScope, contractStart, valorization, client_id, ctr_type_id, payment_method_id, product_id, proj_mgr_id, sector_id) VALUES (2, '1', true, '2023-12-02 10:13:25', '1', null, '2023-01-02 10:13:48', true, 1, 1, 1, 3, 1, 1);
INSERT INTO SIZ.contracts (id, accountNo, activeContract, contractFinish, contractNo, contractScope, contractStart, valorization, client_id, ctr_type_id, payment_method_id, product_id, proj_mgr_id, sector_id) VALUES (3, '1', true, '2023-08-02 10:15:57', '2', null, '2023-05-02 10:16:13', true, 2, 1, 2, 4, 2, 1);



